from flask import Flask, request, jsonify
import jwt
from datetime import datetime, timedelta
import uuid
import os
from functools import wraps

app = Flask(__name__)
app.config['SECRET_KEY'] = os.environ.get('SECRET_KEY', 'zentry-secret-key-for-development')

# Base de datos simulada de usuarios (en producción usarías una BD real)
users_db = {
    'empleado1@zentry.com': {
        'password': 'password123',
        'name': 'Juan Pérez',
        'role': 'analista',
        'id': str(uuid.uuid4())
    },
    'empleado2@zentry.com': {
        'password': 'secure456',
        'name': 'María Gómez',
        'role': 'gerente',
        'id': str(uuid.uuid4())
    },
    'admin@zentry.com': {
        'password': 'admin789',
        'name': 'Admin Zentry',
        'role': 'administrador',
        'id': str(uuid.uuid4())
    }
}

# Tokens activos (simulación de almacenamiento - en producción usarías Redis o similar)
active_tokens = {}

# Decorator para verificar token en rutas protegidas
def token_required(f):
    @wraps(f)
    def decorated(*args, **kwargs):
        token = None
        auth_header = request.headers.get('Authorization')
        
        if auth_header:
            if auth_header.startswith('Bearer '):
                token = auth_header.split(' ')[1]
        
        if not token:
            return jsonify({
                'message': 'Token no proporcionado',
                'success': False
            }), 401
        
        try:
            # Decodificar token
            data = jwt.decode(token, app.config['SECRET_KEY'], algorithms=["HS256"])
            
            # Verificar si el token está en la lista de tokens activos
            if data['id'] not in active_tokens or active_tokens[data['id']] != token:
                return jsonify({
                    'message': 'Token inválido o expirado',
                    'success': False
                }), 401
                
            current_user = data
            
        except jwt.ExpiredSignatureError:
            return jsonify({
                'message': 'Token expirado',
                'success': False
            }), 401
        except jwt.InvalidTokenError:
            return jsonify({
                'message': 'Token inválido',
                'success': False
            }), 401
            
        return f(current_user, *args, **kwargs)
    
    return decorated

@app.route('/')
def index():
    return jsonify({
        'message': 'Bienvenido a la API de Zentry',
        'version': '1.0.0',
        'status': 'online'
    })

@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    
    if not data:
        return jsonify({
            'message': 'Datos no proporcionados',
            'success': False
        }), 400
    
    email = data.get('email')
    password = data.get('password')
    
    if not email or not password:
        return jsonify({
            'message': 'Email y contraseña son requeridos',
            'success': False
        }), 400
    
    # Verificar si el usuario existe
    if email not in users_db:
        return jsonify({
            'message': 'Usuario no encontrado',
            'success': False
        }), 401
    
    # Verificar contraseña
    if users_db[email]['password'] != password:
        return jsonify({
            'message': 'Contraseña incorrecta',
            'success': False
        }), 401
    
    # Generar token JWT
    token_payload = {
        'id': users_db[email]['id'],
        'email': email,
        'role': users_db[email]['role'],
        'exp': datetime.utcnow() + timedelta(hours=24)  # Expiración en 24 horas
    }
    
    token = jwt.encode(token_payload, app.config['SECRET_KEY'], algorithm="HS256")
    
    # Guardar token en activos
    active_tokens[users_db[email]['id']] = token
    
    return jsonify({
        'message': 'Inicio de sesión exitoso',
        'token': token,
        'success': True
    }), 200

@app.route('/profile', methods=['GET'])
@token_required
def get_profile(current_user):
    # Buscar el usuario por email
    email = current_user['email']
    
    if email not in users_db:
        return jsonify({
            'message': 'Usuario no encontrado',
            'success': False
        }), 404
    
    user_data = users_db[email]
    
    # No devolver la contraseña
    return jsonify({
        'id': user_data['id'],
        'name': user_data['name'],
        'email': email,
        'role': user_data['role'],
        'success': True
    }), 200

@app.route('/logout', methods=['POST'])
@token_required
def logout(current_user):
    # Eliminar token de la lista de tokens activos
    if current_user['id'] in active_tokens:
        del active_tokens[current_user['id']]
    
    return jsonify({
        'message': 'Cierre de sesión exitoso',
        'success': True
    }), 200

@app.route('/users', methods=['GET'])
@token_required
def get_users(current_user):
    # Verificar si el usuario es administrador
    if current_user['role'] != 'administrador':
        return jsonify({
            'message': 'No autorizado para ver esta información',
            'success': False
        }), 403
    
    # Preparar lista de usuarios (sin contraseñas)
    users_list = []
    for email, data in users_db.items():
        users_list.append({
            'id': data['id'],
            'name': data['name'],
            'email': email,
            'role': data['role']
        })
    
    return jsonify({
        'users': users_list,
        'success': True
    }), 200

# Manejo de errores
@app.errorhandler(404)
def not_found(error):
    return jsonify({
        'message': 'Endpoint no encontrado',
        'success': False
    }), 404

@app.errorhandler(500)
def server_error(error):
    return jsonify({
        'message': 'Error interno del servidor',
        'success': False
    }), 500

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(host='0.0.0.0', port=port, debug=True)

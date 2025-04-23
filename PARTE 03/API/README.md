## Instrucciones para ejecutar la API Flask
Para ejecutar esta API de Flask, sigue estos pasos:

### Preparación del entorno

1. **Crea un entorno virtual**:
   ```bash
   python -m venv venv
   ```

2. **Activa el entorno virtual**:
     ```bash
     venv\Scripts\activate
     ```

3. **Instala las dependencias**:
   ```bash
   pip install -r requirements.txt
   ```

### Ejecuta la API

```bash
python app.py
```

## Endpoints de la API

| Endpoint | Método | Descripción | Autenticación requerida |
|----------|--------|-------------|------------------------|
| `/login` | POST | Autentica al usuario y devuelve un token JWT | No |
| `/profile` | GET | Devuelve información del perfil del usuario actual | Sí |
| `/logout` | POST | Cierra la sesión invalidando el token | Sí |
| `/users` | GET | Devuelve la lista de todos los usuarios (solo para administradores) | Sí |

## Descripción de los endpoints

1. **`/login` (POST)**
   - Autentica al usuario y devuelve un token JWT
   - Datos requeridos: email y password

2. **`/profile` (GET)**
   - Devuelve información del perfil del usuario actual
   - Requiere token de autenticación en el header Authorization

3. **`/logout` (POST)**
   - Cierra la sesión invalidando el token
   - Requiere token de autenticación

4. **`/users` (GET)**
   - Devuelve la lista de todos los usuarios (solo para administradores)
   - Requiere token de autenticación

## Para un entorno de producción
Para un entorno de producción, deberías considerar:

1. **Seguridad mejorada**:
   - Usar HTTPS con certificados SSL
   - Implementar hashing de contraseñas con bcrypt o similar
   - Usar una base de datos real (PostgreSQL, MySQL)

2. **Gestión de tokens mejorada**:
   - Usar Redis para almacenar tokens activos
   - Implementar refresh tokens

3. **Despliegue**:
   - Desplegar en un servicio como Heroku, AWS, Google Cloud, etc.
   - Configurar variables de entorno para las credenciales sensibles


![FinCo App Screenshot](https://raw.githubusercontent.com/juanitoeldesastre/seminario2/main/Tarea03/img/apilogin.PNG)

### Backend
- Python 3
- Flask
- PyJWT (para generación y validación de tokens)
- Autenticación mediante tokens JWT
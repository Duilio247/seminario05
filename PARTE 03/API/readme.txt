API de ZENTRY 

La API está hecha en Flask y se conecta con app Android "Zentry" (paquete: com.cursospea.pyaprendizaje3). 
Este ofrece funciones de autenticación y gestión de usuarios usando tokens JWT.

ENDPOINTS:
- POST /login -> Iniciar sesión, devuelve token.
- GET /profile -> Datos del usuario autenticado (requiere token).
- POST /logout -> Cerrar sesión (requiere token).
- GET /users -> Lista de usuarios (solo administradores, requiere token).

ARCHIVOS RELACIONADOS EN EL PROYECTO ANDROID:
- AndroidManifest.xml -> Permisos de internet, registro de Activities.
- ApiService.java -> Define las llamadas a la API con Retrofit.
- LoginRequest.java -> Modelo para login (email, password).
- LoginResponse.java -> Respuesta de login (token, mensaje).
- User.java -> Modelo de perfil de usuario.
- UserListResponse.java -> Modelo para listar usuarios.

FLUJO EN LA APP:
1. LoginActivity envía email/password -> guarda token recibido.
2. MainActivity / ProfileActivity usa token para consultar datos.
3. Opción de logout para eliminar token guardado.
4. Usuarios con rol "administrador" pueden consultar lista de usuarios.

REQUISITOS PARA API:
- Python 3.8+
- Flask
- PyJWT

NOTAS:
- Contraseñas en texto plano (solo para pruebas).
- Para producción: usar bases de datos y cifrado de contraseñas.


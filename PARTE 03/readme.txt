# Zentry - Proyecto de Registro de Usuario y Autenticación

## Características

- Autenticación: Login y registro de usuarios con validación.
- JWT: Uso de tokens para la autenticación de usuarios.
- Perfil de Usuario: Permite ver y editar datos del perfil del usuario.
- Almacenamiento Local: Utiliza `SharedPreferences` para guardar el token de autenticación.
- Interfaz de Usuario: Diseño simple y funcional con Android, usando `MaterialComponents`.

## Tecnologías Utilizadas

- Frontend: 
  - Android Studio
  - Java
  - Material Design (MaterialComponents)
  - Retrofit 2 para realizar las peticiones HTTP

- Backend:
  - Flask (Python)
  - JWT para autenticación
  - SQLite para almacenamiento de datos

## Estructura del Proyecto

- MainActivity: Pantalla de inicio que redirige al login o al perfil del usuario según el estado de sesión.
- LoginActivity: Pantalla para ingresar las credenciales del usuario. 
- ProfileActivity: Muestra y permite la edición de datos del perfil del usuario.
- ApiClient: Clase que gestiona las conexiones HTTP con el backend.
- SessionManager: Maneja el estado de la sesión y almacenamiento de tokens.
- LoginRequest/Response: Clases de solicitud y respuesta para el inicio de sesión.

##Backend Flask debe correr en:
http://10.0.2.2:5000/

## Funcionalidad

- Login: Los usuarios pueden iniciar sesión usando su email y contraseña. Se utiliza JWT para la autenticación.
- Perfil del Usuario: Una vez logueado, los usuarios pueden acceder a su perfil y actualizar sus datos.
- Sesión Persistente: El estado de la sesión del usuario se guarda en `SharedPreferences` para mantener al usuario logueado entre sesiones.

## Dependencias

- Retrofit 2: para realizar peticiones HTTP.
- Gson: para la conversión de JSON a objetos Java.
- OkHttp: cliente HTTP para Retrofit.
- Material Components: para el diseño de la interfaz.



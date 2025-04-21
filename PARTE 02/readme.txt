# Registro de Usuarios con BD - App Android

Esta es una aplicación Android que permite registrar, editar y visualizar usuarios con sus datos personales y profesionales, incluyendo una imagen de perfil.

# Características

- Registro de usuario con:
  - Nombre
  - Profesión
  - Teléfono
  - Correo electrónico
  - Descripción personal
  - Imagen de perfil desde la galería
- Visualización en una lista con diseño personalizado
- Actualización y eliminación de usuarios
- Almacenamiento de datos usando 'SharedPreferences' y 'Gson'
- Diseño moderno con 'Material Components'

# Tecnologías

- Java
- Android SDK
- SharedPreferences
- Gson
- Material Design
- ImageView + Galería para selección de imágenes

# Estructura

- 'MainActivity': Lista los usuarios registrados.
- 'AddEditUserActivity': Permite registrar o editar un usuario.
- 'UserAdapter': Adaptador personalizado para mostrar los usuarios.
- 'user_item.xml': Layout de cada usuario en la lista.
- 'activity_add_edit_user.xml': Formulario de ingreso/edición de usuarios.

# Requisitos

- Android Studio
- Android API 21 o superior
- Permiso de acceso a galería (API >= 23)

# Notas

- Las imágenes se manejan mediante URIs y se muestran directamente en los 'ImageView'.
- Los datos se guardan de forma local y persistente con 'SharedPreferences'.


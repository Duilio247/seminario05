# CRUD Inventario Electrónicos

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar un inventario de productos electrónicos. La aplicación está construida utilizando Node.js y Bootstrap 5, y permite a los usuarios administrar productos de manera eficiente.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de archivos:

```
crud-inventario-electronicos
├── controllers
│   └── productosController.js  // Controlador para manejar operaciones CRUD de productos
├── models
│   └── producto.js             // Modelo de datos para un producto
├── public
│   ├── css
│   │   └── styles.css          // Estilos CSS personalizados
│   └── js
│       └── scripts.js          // Scripts JavaScript personalizados
├── routes
│   └── productos.js            // Rutas para operaciones CRUD de productos
├── views
│   ├── layouts
│   │   └── main.ejs            // Plantilla principal para renderizar vistas
│   ├── productos
│   │   ├── crear.ejs           // Vista para crear un nuevo producto
│   │   ├── editar.ejs          // Vista para editar un producto existente
│   │   ├── listar.ejs          // Vista para listar todos los productos
│   │   └── ver.ejs             // Vista para ver los detalles de un producto
│   └── partials
│       ├── header.ejs          // Encabezado de la aplicación
│       └── footer.ejs          // Pie de página de la aplicación
├── app.js                       // Punto de entrada de la aplicación
├── package.json                 // Archivo de configuración de npm
└── README.md                    // Documentación del proyecto
```

## Instalación

1. Clona el repositorio en tu máquina local:
   ```
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Navega al directorio del proyecto:
   ```
   cd crud-inventario-electronicos
   ```

3. Instala las dependencias:
   ```
   npm install
   ```

4. Inicia la aplicación:
   ```
   npm start
   ```

## Uso

- Accede a la aplicación en tu navegador en `http://localhost:3000`.
- Puedes crear, listar, editar y eliminar productos electrónicos a través de la interfaz de usuario.

## Capturas

- Lista de Productos
![listas](https://github.com/user-attachments/assets/09f2a5c8-eeb0-480b-b5cd-7f88e68688d2)
- Crear nuevo producto
![crear](https://github.com/user-attachments/assets/e47a76d2-06db-4a30-b529-755b445ccaf2)
- Detalles del producto
![detalles](https://github.com/user-attachments/assets/2cc01d2b-1ff6-4671-9103-e2f4d902c788)
- Actualizar producto
![actualizar](https://github.com/user-attachments/assets/c140ed53-9b69-4377-8e03-392ef0494b29)
- Eliminar producto
![eliminar](https://github.com/user-attachments/assets/af3e03a6-2128-45ea-8fb6-8f63e51a66e3)
- BD
![bd](https://github.com/user-attachments/assets/d064088d-960b-4048-998d-5db6c7d64ae8)

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.

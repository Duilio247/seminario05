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

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.
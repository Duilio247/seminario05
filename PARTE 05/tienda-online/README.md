#  Tienda de Artesanías Online

Una aplicación web moderna desarrollada con React para una tienda de artesanías que permite a los usuarios explorar productos únicos, agregarlos al carrito de compras y realizar consultas.

##  Características

- **SPA (Single Page Application)**: Navegación fluida sin recarga de página
- **Catálogo de Productos**: Visualización de artesanías con imágenes y descripciones
- **Carrito de Compras**: Agregar, eliminar y gestionar productos
- **Detalles de Producto**: Vista detallada de cada artesanía
- **Formulario de Contacto**: Comunicación directa con la tienda
- **Diseño Responsive**: Optimizado para desktop, tablet y móvil
- **Interfaz Moderna**: Diseño limpio y atractivo

##  Tecnologías Utilizadas

- **React 18**: Biblioteca principal para la interfaz de usuario
- **React Router DOM**: Navegación y enrutamiento
- **CSS3**: Estilos y diseño responsive
- **JavaScript ES6+**: Lógica de la aplicación
- **Create React App**: Configuración y herramientas de desarrollo

##  Instalación

### Prerrequisitos

- Node.js (versión 14 o superior)
- npm o yarn

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/tienda-online.git
   cd tienda-online
   ```

2. **Instalar dependencias**
   ```bash
   npm install
   ```

3. **Agregar el logo (opcional)**
   - Coloca tu archivo `logo.png` en la carpeta `public/`

4. **Iniciar la aplicación**
   ```bash
   npm start
   ```

5. **Abrir en el navegador**
   - La aplicación estará disponible en `http://localhost:3000`

##  Estructura del Proyecto

```
tienda-online/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├── logo192.png
│   ├── logo512.png
│   ├── manifest.json
│   ├── robots.txt
│   └── logo.png (opcional - para el header)
├── src/
│   ├── components/
│   │   ├── Header.js
│   │   ├── ProductList.js
│   │   ├── ProductDetail.js
│   │   ├── Cart.js
│   │   └── ContactForm.js
│   ├── styles/
│   │   ├── Header.css
│   │   ├── ProductList.css
│   │   ├── ProductDetail.css
│   │   ├── Cart.css
│   │   └── ContactForm.css
│   ├── data/
│   │   └── products.js
│   ├── App.js
│   ├── App.css
│   ├── App.test.js
│   ├── index.js
│   ├── index.css
│   ├── logo.svg
│   ├── reportWebVitals.js
│   └── setupTests.js
├── node_modules/ (generado automáticamente)
├── .gitignore
├── package.json
├── package-lock.json
└── README.md
```

##  Componentes

### Header
- **Funcionalidad**: Navegación principal y logo
- **Responsive**: Menú hamburguesa en móviles
- **Props**: `cartCount` - número de productos en el carrito
- **Estilos**: `src/styles/Header.css`

### ProductList
- **Funcionalidad**: Muestra el catálogo de productos
- **Props**: `addToCart` - función para agregar productos
- **Estilos**: `src/styles/ProductList.css`

### ProductDetail
- **Funcionalidad**: Vista detallada de un producto específico
- **Props**: `addToCart` - función para agregar al carrito
- **Estilos**: `src/styles/ProductDetail.css`

### Cart
- **Funcionalidad**: Gestión del carrito de compras
- **Props**: `cart`, `removeFromCart` - estado y función de eliminación
- **Estilos**: `src/styles/Cart.css`

### ContactForm
- **Funcionalidad**: Formulario de contacto con validación
- **Estado**: Maneja datos del formulario y envío
- **Estilos**: `src/styles/ContactForm.css`

##  Funcionalidades

### Gestión de Estado
- **useState**: Manejo del carrito y formularios
- **Props drilling**: Comunicación entre componentes
- **Local state**: Estado específico de cada componente

### Enrutamiento
- **React Router**: Navegación SPA
- **Rutas dinámicas**: `/product/:id` para detalles
- **Navegación programática**: Redirecciones automáticas

### Eventos y Formularios
- **onClick**: Agregar/eliminar productos
- **onChange**: Actualización de formularios
- **onSubmit**: Envío de formulario de contacto

##  Responsive Design

### Breakpoints
- **Desktop**: > 1024px - Layout completo
- **Tablet**: 769px - 1024px - Layout adaptado
- **Móvil**: < 768px - Menú hamburguesa y layout vertical

### Características Responsive
- **Header**: Logo + texto en desktop, solo logo en móvil
- **Grid**: Productos se adaptan automáticamente
- **Menú**: Hamburguesa con overlay en móviles
- **Imágenes**: Escalado proporcional

##  Organización de Estilos

Los estilos están organizados en la carpeta `src/styles/` para mejor mantenimiento:

- `App.css` - Estilos globales y configuración base
- `Header.css` - Estilos del header y navegación responsive
- `ProductList.css` - Estilos del catálogo de productos
- `ProductDetail.css` - Estilos de la vista detallada
- `Cart.css` - Estilos del carrito de compras
- `ContactForm.css` - Estilos del formulario de contacto

##  Capturas del Proyecto

- Catalogo de Productos
  ![dash](https://github.com/user-attachments/assets/2736731b-dc57-4737-a4bc-f7f558dec8f4)
  
- Detalles del Producto
  ![detalle](https://github.com/user-attachments/assets/79dc0408-c73a-47ec-b396-fd255e3f47b2)
  
- Carrito de Compra
  ![carrito](https://github.com/user-attachments/assets/55e65b7f-c60e-42f7-b9c1-bc47082f74b6)

- Formulario de Contacto
  ![contacto](https://github.com/user-attachments/assets/867fcae2-42c0-4453-8d0c-8164bb098b3b)

##  Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

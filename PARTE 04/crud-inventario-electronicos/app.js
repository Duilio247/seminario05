const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const multer = require('multer');
const productosRoutes = require('./routes/productos');

const app = express();
const PORT = process.env.PORT || 3000;

// Configuración de middleware
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));

// Configuración de vistas
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Rutas
app.use('/productos', productosRoutes);

// Ruta principal
app.get('/', (req, res) => {
    res.redirect('/productos/listar');
});

// Iniciar el servidor
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
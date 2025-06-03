const express = require('express');
const router = express.Router();
const multer = require('multer');
const upload = multer({ dest: 'public/uploads/' });
const connection = require('../config/db');
const productosController = require('../controllers/productosController');

// Listar productos (vista)
router.get('/listar', (req, res) => {
    connection.query("SELECT * FROM productos", (err, results) => {
        if (err) throw err;
        res.render('productos/listar', { productos: results });
    });
});

// Formulario crear producto (vista)
router.get('/crear', (req, res) => {
    res.render('productos/crear');
});

// Crear producto (POST) con imagen
router.post('/crear', upload.single('imagen'), productosController.crearProducto);

// Ver detalles de producto (vista)
router.get('/ver/:id', (req, res) => {
    const { id } = req.params;
    connection.query("SELECT * FROM productos WHERE id = ?", [id], (err, results) => {
        if (err) throw err;
        if (results.length > 0) {
            res.render('productos/ver', { producto: results[0] });
        } else {
            res.redirect('/productos/listar');
        }
    });
});

// Formulario editar producto (vista)
router.get('/editar/:id', productosController.editarProducto);

// Actualizar producto (POST) con imagen
router.post('/actualizar/:id', upload.single('imagen'), productosController.actualizarProducto);

// Eliminar producto (POST)
router.post('/eliminar/:id', productosController.eliminarProducto);

module.exports = router;

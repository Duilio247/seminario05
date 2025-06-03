const connection = require('../config/db'); // Asegúrate de tener la conexión a la base de datos configurada

// Operación de Creación (Create):
exports.crearProducto = (req, res) => {
    const nuevoProducto = {
        nombre: req.body.nombre,
        precio: req.body.precio,
        stock: req.body.stock,
        imagen: req.file ? req.file.filename : null
    };

    connection.query("INSERT INTO productos SET ?", nuevoProducto, (err, result) => {
        if (err) throw err;
        res.render('productos/crear', {
            mensaje: 'Producto creado exitosamente'
        });
    });
};



// Operación de Edicion (Edit):
exports.editarProducto = (req, res) => {
    const id = req.params.id;
    connection.query("SELECT * FROM productos WHERE id = ?", [id], (err, results) => {
        if (err) throw err;
        if (results.length > 0) {
            res.render('productos/editar', { producto: results[0] });
        } else {
            res.redirect('/productos/listar');
        }
    });
};


// Operación de Lectura (Read):
exports.listarProductos = (req, res) => {
    connection.query("SELECT * FROM productos", (err, results) => {
        if (err) throw err;
        res.json(results);
    });
};

exports.obtenerProductoPorId = (req, res) => {
    const id = req.params.id;
    connection.query("SELECT * FROM productos WHERE id = ?", [id], (err, result) => {
        if (err) throw err;
        res.json(result[0]);
    });
};

// Operación de Actualización (Update):
exports.actualizarProducto = (req, res) => {
    const id = req.params.id;
    const productoActualizado = {
        nombre: req.body.nombre,
        precio: req.body.precio,
        stock: req.body.stock,
        imagen: req.file ? req.file.filename : req.body.imagenActual
    };
    connection.query("UPDATE productos SET ? WHERE id = ?", [productoActualizado, id], (err, result) => {
        if (err) throw err;
        // Obtener el producto actualizado para mostrarlo en el formulario
        connection.query("SELECT * FROM productos WHERE id = ?", [id], (err2, results) => {
            if (err2) throw err2;
            res.render('productos/editar', { 
                producto: results[0],
                mensaje: 'Producto actualizado exitosamente'
            });
        });
    });
};

// Operación de Eliminación (Delete):
exports.eliminarProducto = (req, res) => {
    const { id } = req.params;
    const connection = require('../config/db');
    connection.query('DELETE FROM productos WHERE id = ?', [id], (err, result) => {
        if (err) throw err;
        res.redirect('/productos/listar');
    });
};
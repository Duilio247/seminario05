// filepath: /crud-inventario-electronicos/crud-inventario-electronicos/public/js/scripts.js
document.addEventListener('DOMContentLoaded', function() {
    // Código para manejar la interactividad en las vistas
    const eliminarBotones = document.querySelectorAll('.btn-eliminar');

    eliminarBotones.forEach(boton => {
        boton.addEventListener('click', function(event) {
            if (!confirm('¿Estás seguro de que deseas eliminar este producto?')) {
                event.preventDefault();
            }
        });
    });
});
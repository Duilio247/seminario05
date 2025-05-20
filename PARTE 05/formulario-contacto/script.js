// script.js - Funcionalidad para el formulario de contacto

// Esperar a que el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', function() {
  // Referencia al formulario
  const contactForm = document.getElementById('contactForm');
  
  // Validar que el formulario exista en la página
  if (!contactForm) {
    console.error('El formulario con ID "contactForm" no se encontró en la página.');
    return;
  }
  
  // Función para validar el formato de un correo electrónico
  function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }
  
  // Función para mostrar mensaje de error
  function mostrarError(input, mensaje) {
    // Eliminar mensaje anterior si existe
    const mensajeAnterior = input.parentElement.querySelector('.error-mensaje');
    if (mensajeAnterior) {
      mensajeAnterior.remove();
    }
    
    // Crear nuevo mensaje de error
    const mensajeError = document.createElement('div');
    mensajeError.className = 'error-mensaje';
    mensajeError.textContent = mensaje;
    
    // Añadir borde rojo al input
    input.style.borderColor = '#e74c3c';
    
    // Insertar mensaje después del input
    input.parentElement.appendChild(mensajeError);
    
    return false;
  }
  
  // Función para limpiar mensaje de error
  function limpiarError(input) {
    const mensajeError = input.parentElement.querySelector('.error-mensaje');
    if (mensajeError) {
      mensajeError.remove();
    }
    input.style.borderColor = '#ddd';
    return true;
  }
  
  // Validar formulario al enviar
  contactForm.addEventListener('submit', function(e) {
    let esValido = true;
    
    // Referencias a los campos del formulario
    const nombre = document.getElementById('nombre');
    const email = document.getElementById('email');
    const mensaje = document.getElementById('mensaje');
    
    // Validar que los campos existan
    if (!nombre || !email || !mensaje) {
      console.error('Uno o más campos del formulario no se encontraron.');
      return;
    }
    
    // Validar nombre
    if (nombre.value.trim() === '') {
      esValido = mostrarError(nombre, 'Por favor, ingresa tu nombre');
    } else {
      limpiarError(nombre);
    }
    
    // Validar email
    if (email.value.trim() === '') {
      esValido = mostrarError(email, 'Por favor, ingresa tu correo electrónico');
    } else if (!validarEmail(email.value)) {
      esValido = mostrarError(email, 'Por favor, ingresa un correo electrónico válido');
    } else {
      limpiarError(email);
    }
    
    // Validar mensaje
    if (mensaje.value.trim() === '') {
      esValido = mostrarError(mensaje, 'Por favor, escribe tu mensaje');
    } else {
      limpiarError(mensaje);
    }
    
    // Prevenir envío si hay errores
    if (!esValido) {
      e.preventDefault();
    } else {
      // Para simulación de envío exitoso (quitar en producción)
      e.preventDefault();
      
      // Mostrar mensaje de éxito
      const mensajeExito = document.createElement('div');
      mensajeExito.className = 'success-mensaje';
      mensajeExito.textContent = '¡Gracias! Tu mensaje ha sido enviado correctamente.';
      
      // Insertar mensaje después del formulario
      contactForm.parentElement.appendChild(mensajeExito);
      
      // Limpiar formulario
      contactForm.reset();
      
      // Eliminar mensaje después de 5 segundos
      setTimeout(function() {
        mensajeExito.remove();
      }, 5000);
    }
  });
  
  // Validación en tiempo real cuando el usuario pierde el foco en un campo
  const inputs = contactForm.querySelectorAll('input, textarea');
  inputs.forEach(function(input) {
    input.addEventListener('blur', function() {
      if (this.id === 'nombre' && this.value.trim() === '') {
        mostrarError(this, 'Por favor, ingresa tu nombre');
      } else if (this.id === 'email') {
        if (this.value.trim() === '') {
          mostrarError(this, 'Por favor, ingresa tu correo electrónico');
        } else if (!validarEmail(this.value)) {
          mostrarError(this, 'Por favor, ingresa un correo electrónico válido');
        } else {
          limpiarError(this);
        }
      } else if (this.id === 'mensaje' && this.value.trim() === '') {
        mostrarError(this, 'Por favor, escribe tu mensaje');
      } else {
        limpiarError(this);
      }
    });
  });
  
  // Log para verificar que el script se cargó correctamente
  console.log('Script del formulario inicializado correctamente');
});
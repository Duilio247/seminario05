import { useState } from 'react';
import '../styles/ContactForm.css';

function ContactForm() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: ''
  });
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [submitStatus, setSubmitStatus] = useState(null);

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    
    // Simular envío del formulario
    try {
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      console.log('Formulario enviado:', formData);
      setSubmitStatus('success');
      setFormData({ name: '', email: '', message: '' });
    } catch (error) {
      setSubmitStatus('error');
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="contact-container">
      <h2 className="contact-title">Contáctanos</h2>
      
      <form onSubmit={handleSubmit} className="contact-form">
        {submitStatus === 'success' && (
          <div className="success-message">
            ¡Mensaje enviado correctamente! Te responderemos pronto.
          </div>
        )}
        
        {submitStatus === 'error' && (
          <div className="error-message">
            Hubo un error al enviar el mensaje. Por favor, inténtalo de nuevo.
          </div>
        )}

        <div className="form-group">
          <label htmlFor="name">Nombre:</label>
          <input type="text" id="name" name="name" value={formData.name} onChange={handleChange} required disabled={isSubmitting}/>
        </div>

        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} required disabled={isSubmitting}/>
        </div>

        <div className="form-group">
          <label htmlFor="message">Mensaje:</label>
          <textarea id="message" name="message" value={formData.message} onChange={handleChange} required disabled={isSubmitting} placeholder="Escribe tu mensaje aquí..."/>
        </div>

        <button type="submit" className="btn-submit" disabled={isSubmitting}>
          {isSubmitting ? 'Enviando...' : 'Enviar Mensaje'}
        </button>
      </form>
    </div>
  );
}

export default ContactForm;

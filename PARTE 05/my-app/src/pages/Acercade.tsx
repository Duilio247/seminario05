import { useState, FormEvent } from 'react';

export default function Acercade() {
  const [nombre, setNombre] = useState('');
  const [correo, setCorreo] = useState('');
  const [mensaje, setMensaje] = useState('');
  const [enviado, setEnviado] = useState(false);

  const manejarEnvio = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setEnviado(true);
  };

  return (
    <div>
      <h2>Acerca de</h2>
      <p>Acerca de nuestra aplicación</p>
      {enviado ? (
        <p style={{ color: 'green' }}>
          Gracias, {nombre}. Te responderemos a {correo}.
        </p>
      ) : (
        <form onSubmit={manejarEnvio}>
          <div>
            <label>Nombre completo:</label><br />
            <input
              type="text"
              value={nombre}
              onChange={(e) => setNombre(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Correo electrónico:</label><br />
            <input
              type="email"
              value={correo}
              onChange={(e) => setCorreo(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Mensaje:</label><br />
            <textarea
              value={mensaje}
              onChange={(e) => setMensaje(e.target.value)}
              required
            />
          </div>
          <button type="submit">Enviar</button>
        </form>
      )}
    </div>
  );
}

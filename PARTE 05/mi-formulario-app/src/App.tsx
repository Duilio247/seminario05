import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import FormularioContacto from './components/FormularioContacto';
import FormularioEstudiante from './components/FormularioEstudiante';

export default function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: '10px', backgroundColor: '#f0f0f0' }}>
        <Link to="/" style={{ marginRight: '10px' }}>Inicio</Link>
        <Link to="/contacto" style={{ marginRight: '10px' }}>Contacto</Link>
        <Link to="/registro" style={{ marginRight: '10px' }}>Registro</Link>
      </nav>

      <div style={{ padding: '20px' }}>
        <h1>Mi App con React + TypeScript</h1>

        <Routes>
          <Route path="/" element={<p>Bienvenido a la página de inicio.</p>} />
          <Route path="/contacto" element={<FormularioContacto />} />
          <Route path="/registro" element={<FormularioEstudiante />} />
          <Route path="*" element={<p>Página no encontrada (404)</p>} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

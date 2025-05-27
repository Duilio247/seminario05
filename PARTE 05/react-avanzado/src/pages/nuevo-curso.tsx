import { useState, FormEvent } from 'react';
import { useNavigate } from 'react-router-dom';

export default function NuevoCurso() {
  const [nombre, setNombre] = useState('');
  const [docente, setDocente] = useState('');
  const [duracion, setDuracion] = useState('');
  const [carrera, setCarrera] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    if (!nombre || !docente || !duracion || !carrera) {
      setError('*Todos los campos son obligatorios');
      return;
    }
    const nuevoCurso = { nombre, docente, duracion, carrera };
    navigate('/cursos', { state: { nuevoCurso } });
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-md mx-auto p-4 border rounded shadow">
      <h2>Nuevo Curso</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <input placeholder="Nombre del curso" value={nombre} onChange={e => setNombre(e.target.value)} className="block w-full my-2 p-2 border" /><br />
      <input placeholder="Docente" value={docente} onChange={e => setDocente(e.target.value)} className="block w-full my-2 p-2 border" /><br />
      <input placeholder="Duración" value={duracion} onChange={e => setDuracion(e.target.value)} className="block w-full my-2 p-2 border" /><br />
      <select value={carrera} onChange={e => setCarrera(e.target.value)} className="block w-full my-2 p-2 border">
        <option value="">Selecciona una carrera</option>
        <option value="Informática">Informática</option>
        <option value="Redes">Redes</option>
        <option value="Sistemas">Sistemas</option>
      </select><br />
      <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">Agregar Curso</button>
    </form>
  );
}


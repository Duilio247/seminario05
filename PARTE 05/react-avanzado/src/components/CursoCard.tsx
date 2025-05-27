import React from 'react';
import type { Curso } from '../types/curso';

const CursoCard: React.FC<Curso> = ({ nombre, docente, duracion, carrera }) => {
  return (
    <div className="border p-4 rounded shadow mb-4 bg-gray-50">
      <h3 className="text-xl font-semibold mb-2">{nombre}</h3>
      <p><strong>Docente:</strong> {docente}</p>
      <p><strong>Duración:</strong> {duracion}</p>
      <p><strong>Carrera:</strong> {carrera}</p>
    </div>
  );
};

export default CursoCard;

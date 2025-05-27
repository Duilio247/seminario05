import React from 'react';
import type { Estudiante } from '../types/estudiante';

const EstudianteCard: React.FC<Estudiante> = ({ nombre, carrera, correo }) => {
  return (
    <div className="border p-4 rounded shadow mb-4 bg-white">
      <h3 className="text-xl font-semibold mb-2">{nombre}</h3>
      <p><strong>Carrera:</strong> {carrera}</p>
      <p><strong>Correo:</strong> {correo}</p>
    </div>
  );
};

export default EstudianteCard;

import { useLocation } from 'react-router-dom';
import CursoCard from '../components/CursoCard';
import type { Curso } from '../types/curso';

export default function Cursos() {
    const location = useLocation();
    const nuevoCurso = location.state?.nuevoCurso as Curso | undefined;

    const cursos: Curso[] = [
        { nombre: 'React Básico', docente: 'María Rojas', duracion: '6 semanas', carrera: 'Informática' },
        { nombre: 'Redes I', docente: 'Carlos Díaz', duracion: '4 semanas', carrera: 'Redes' },
        ...(nuevoCurso ? [nuevoCurso] : [])
    ];

    return (
        <div>
            <h2 className="text-xl mb-4">Lista de Cursos</h2>
            {nuevoCurso && (
                <p className="mb-4 text-green-600">Curso registrado exitosamente</p>
            )}
            {cursos.map((curso, i) => (
                <CursoCard key={i} {...curso} />
            ))}
        </div>
    );
}

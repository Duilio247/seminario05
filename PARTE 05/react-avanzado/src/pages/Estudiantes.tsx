import { useLocation } from 'react-router-dom'
import EstudianteCard from '../components/EstudianteCard'
import type { Estudiante } from '../types/estudiante'

export default function Estudiantes() {
    const location = useLocation()
    const nuevoEstudiante = location.state as Estudiante | null

    const listaBase: Estudiante[] = [
        { nombre: 'Ana Torres', carrera: 'Informática', correo: 'ana@mail.com' },
        { nombre: 'Luis Ramos', carrera: 'Redes', correo: 'luis@mail.com' },
        { nombre: 'María Salas', carrera: 'Sistemas', correo: 'maria@mail.com' }
    ]

    const listaEstudiantes = nuevoEstudiante
        ? [...listaBase, nuevoEstudiante]
        : listaBase

    return (
        <div className="max-w-2xl mx-auto px-4 py-6">
            <h2 className="text-2xl font-bold mb-4">Listado de Estudiantes</h2>
            {nuevoEstudiante && (
                <p className="mb-4 text-green-600">Estudiante registrado exitosamente</p>
            )}
            {listaEstudiantes.map((estudiante, index) => (
                <EstudianteCard key={index} {...estudiante} />
            ))}
        </div>
    )
}

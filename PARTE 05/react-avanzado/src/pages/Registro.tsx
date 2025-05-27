import { useState, FormEvent } from 'react'
import { useNavigate } from 'react-router-dom'

export default function Registro() {
    const [nombre, setNombre] = useState('')
    const [correo, setCorreo] = useState('')
    const [carrera, setCarrera] = useState('')
    const [error, setError] = useState('')
    const navigate = useNavigate()

    const handleSubmit = (e: FormEvent) => {
        e.preventDefault()
        if (!nombre || !correo || !carrera) {
            setError('*Todos los campos son obligatorios')
            return
        }

        navigate('/estudiantes', {
            state: { nombre, correo, carrera }
        })
    }

    return (
        <form onSubmit={handleSubmit}>
            <h2>Registro de Estudiante</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <input placeholder="Nombre" value={nombre} onChange={(e) => setNombre(e.target.value)} /><br />
            <input placeholder="Correo" value={correo} onChange={(e) => setCorreo(e.target.value)} type="email" /><br />
            <input placeholder="Carrera" value={carrera} onChange={(e) => setCarrera(e.target.value)} /><br />
            <button type="submit">Registrar</button>
        </form>
    );
}

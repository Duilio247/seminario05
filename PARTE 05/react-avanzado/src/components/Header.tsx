import { Link } from 'react-router-dom';

export default function Header() {
    return (
        <header className="bg-blue-600 text-white p-4">
            <div className="max-w-6xl mx-auto flex justify-between items-center">
                <h1 className="text-xl font-bold">Gestión de Estudiantes & Cursos</h1>
                <nav className="mb-4">
                    <Link to="/" className="mr-2">Inicio</Link> | 
                    <Link to="/registro" className="mx-2">Registro</Link> | 
                    <Link to="/estudiantes" className="mx-2">Estudiantes</Link> | 
                    <Link to="/cursos" className="mx-2">Cursos</Link> | 
                    <Link to="/nuevo-curso" className="mx-2">Nuevo Curso</Link>
                </nav>
            </div>
        </header>
    );
}

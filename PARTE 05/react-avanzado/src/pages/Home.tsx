
export default function Home() {
    return (
        <div>
            <h1></h1>
            <nav>
                <ul className="list-disc pl-5">
                    <li><a href="/cursos" className="text-blue-500 hover:underline">Ver Cursos</a></li>
                    <li><a href="/estudiantes" className="text-blue-500 hover:underline">Ver Estudiantes</a></li>
                </ul>
            </nav>
            <hr />
            <p>Utiliza el menú para navegar por el sistema.</p>
        </div>
    );
}

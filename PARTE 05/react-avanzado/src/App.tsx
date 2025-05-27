import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';  
import Registro from './pages/Registro';
import Estudiantes from './pages/Estudiantes';
import Cursos from './pages/Cursos';
import NuevoCurso from './pages/nuevo-curso';
import Header from './components/Header';
import Footer from './components/Footer';

function App() {
  return (
    <div className="flex flex-col min-h-screen">
      <Header />
      <main className="flex-grow p-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/registro" element={<Registro />} />
          <Route path="/estudiantes" element={<Estudiantes />} />
          <Route path="/cursos" element={<Cursos />} />
          <Route path="/nuevo-curso" element={<NuevoCurso />} />
        </Routes>
      </main>
      <Footer />
    </div>
  );
}

export default App;

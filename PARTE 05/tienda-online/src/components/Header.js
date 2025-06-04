import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import '../styles/Header.css';

function Header({ cartCount }) {
  const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);

  const toggleMobileMenu = () => {
    setIsMobileMenuOpen(!isMobileMenuOpen);
  };

  const closeMobileMenu = () => {
    setIsMobileMenuOpen(false);
  };

  useEffect(() => {
    const handleResize = () => {
      if (window.innerWidth > 768) {
        setIsMobileMenuOpen(false);
      }
    };

    const handleClickOutside = (event) => {
      if (isMobileMenuOpen && !event.target.closest('.header-nav')) {
        setIsMobileMenuOpen(false);
      }
    };

    window.addEventListener('resize', handleResize);
    document.addEventListener('click', handleClickOutside);

    if (isMobileMenuOpen) {
      document.body.classList.add('menu-open');
    } else {
      document.body.classList.remove('menu-open');
    }

    return () => {
      window.removeEventListener('resize', handleResize);
      document.removeEventListener('click', handleClickOutside);
      document.body.classList.remove('menu-open');
    };
  }, [isMobileMenuOpen]);

  return (
    <header className="header">
      <nav className="header-nav">
        <Link to="/" className="header-logo" onClick={closeMobileMenu}>
          <img src="/logo.png" alt="Logo Tienda de Artesanías" className="header-logo-img" onError={(e) => {e.target.style.display = 'none'; console.warn('Logo no encontrado en /public/logo.png'); }} />
          <h1>Tienda de Artesanías</h1>
        </Link>

        <div className="header-links">
          <Link to="/" className="header-link">Productos</Link>
          <Link to="/contact" className="header-link">Contacto</Link>
          <Link to="/cart" className="header-link cart-link">
            Carrito ({cartCount})
          </Link>
        </div>

        <button className="mobile-menu-button" onClick={toggleMobileMenu} aria-label={isMobileMenuOpen ? "Cerrar menú" : "Abrir menú"}>
          {isMobileMenuOpen ? '✕' : '☰'}
        </button>
      </nav>

      <div className={`mobile-menu ${isMobileMenuOpen ? 'active' : ''}`}>
        <div className="mobile-menu-links">
          <Link to="/" className="header-link" onClick={closeMobileMenu}>
            <i className="fa-solid fa-bag-shopping"></i> Productos
          </Link>
          <Link to="/contact" className="header-link" onClick={closeMobileMenu}>
            <i className="fa-solid fa-envelope"></i> Contacto
          </Link>

          <Link to="/cart" className="header-link cart-link" onClick={closeMobileMenu}>
            <i className="fa-solid fa-cart-shopping"></i> Carrito ({cartCount})
          </Link>

        </div>
      </div>
    </header>
  );
}

export default Header;

import { Link } from 'react-router-dom';
import { products } from '../data/products';
import '../styles/ProductList.css';

function ProductList({ addToCart }) {
  return (
    <div className="product-list-container">
      <h2 className="product-list-title">Nuestro Catalogo de Productos</h2>
      <div className="products-grid">
        {products.map(product => (
          <div key={product.id} className="product-card">
            <img src={product.imageUrl} alt={product.name} className="product-image" />
            <h3 className="product-name">{product.name}</h3>
            <p className="product-description">
              {product.description.substring(0, 100)}...
            </p>
            <p className="product-price">
              S/. {product.price}
            </p>
            <div className="product-buttons">
              <Link to={`/product/${product.id}`} className="btn-details">
                Ver Detalles
              </Link>
              <button onClick={() => addToCart(product)} className="btn-add-cart">
                Agregar Carrito
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ProductList;

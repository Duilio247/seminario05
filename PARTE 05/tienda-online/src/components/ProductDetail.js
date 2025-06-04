import { useParams, Link } from 'react-router-dom';
import { getProductById } from '../data/products';
import '../styles/ProductDetail.css';

function ProductDetail({ addToCart }) {
  const { id } = useParams();
  const product = getProductById(id);

  if (!product) {
    return (
      <div className="product-not-found">
        <h2>Producto no encontrado</h2>
        <Link to="/" className="back-link">Volver a la tienda</Link>
      </div>
    );
  }

  return (
    <div className="product-detail-container">
      <h2 className="product-list-title">Detalles de Producto</h2>
      <div className="product-detail-grid">
        <div>
          <img
            src={product.imageUrl}
            alt={product.name}
            className="product-detail-image"
          />
        </div>

        <div className="product-detail-info">
          <h1>{product.name}</h1>
          <p className="product-detail-price">
            S/. {product.price}
          </p>
          <p className="product-detail-description">
            {product.description}
          </p>

          <button
            onClick={() => {
              addToCart(product);
              alert('Producto agregado al carrito!');
            }}
            className="btn-add-to-cart"
          >
            Agregar al Carrito
          </button>
        </div>
      </div>
    </div>
  );
}

export default ProductDetail;

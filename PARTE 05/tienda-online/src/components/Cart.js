import { Link } from 'react-router-dom';
import '../styles/Cart.css';

function Cart({ cart, removeFromCart }) {
  const total = cart.reduce((sum, product) => sum + product.price, 0);

  const handleRemoveItem = (index) => {
    // Confirmación antes de eliminar
    if (window.confirm('¿Estás seguro de que quieres eliminar este producto del carrito?')) {
      removeFromCart(index);
    }
  };

  const handleCheckout = () => {
    alert(`¡Gracias por tu compra!\nMonto de Compra: S/. ${total.toFixed(2)}\n\nEsto es una simulación. En una aplicación real, aquí se procesaría el pago.`);
  };

  if (cart.length === 0) {
    return (
      <div className="cart-container">
        <div className="cart-empty">
          <h2>Tu carrito está vacío</h2>
          <p>
            <Link to="/">Continúa comprando</Link> para agregar productos.
          </p>
        </div>
      </div>
    );
  }

  return (
    <div className="cart-container">
      <h2 className="cart-title">Carrito de Compras</h2>

      <div className="cart-items">
        {cart.map((product, index) => (
          <div key={`${product.id}-${index}`} className="cart-item">
            <div className="cart-item-info">
              <img src={product.imageUrl} alt={product.name} className="cart-item-image"/>
              <div className="cart-item-details">
                <h4>{product.name}</h4>
                <p className="cart-item-price">S/. {product.price.toFixed(2)}</p>
              </div>
            </div>
            <button onClick={() => handleRemoveItem(index)} className="btn-remove" title="Eliminar producto del carrito">
              Eliminar
            </button>
          </div>
        ))}
      </div>

      <div className="cart-summary">
        <div className="cart-info">
          <p>Productos en el carrito: <strong>{cart.length}</strong></p>
        </div>
        <h3 className="cart-total">
          Total: <span>S/. {total.toFixed(2)}</span>
        </h3>
        <div className="cart-buttons">
          <button className="btn-checkout" onClick={handleCheckout}>
            Proceder al Pago
          </button>
          <button to="/" className="btn-continue-shopping">
            <Link to="/" className="btn-continue-shopping-link">
              Continuar Comprando
            </Link>
          </button>
        </div>
      </div>
    </div>
  );
}

export default Cart;

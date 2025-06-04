export const products = [
  {
    id: '1',
    name: 'Cerámica Artesanal Azul',
    price: 55.90,
    description: 'Hermosa pieza de cerámica hecha a mano, esmaltada en tonos azules vibrantes. Perfecta para decorar o como un regalo especial.',
    imageUrl: 'https://i.postimg.cc/XYY2h852/ceramicasazul.png',
  },
  {
    id: '2',
    name: 'Tejido de Alpaca Andino',
    price: 79.50,
    description: 'Suave y cálido tejido de alpaca, con diseños tradicionales andinos. Ideal para los días fríos o zonas con temperaturas bajas...',
    imageUrl: 'https://i.postimg.cc/g0rTwDkw/tejidoalpaca.png',
  },
  {
    id: '3',
    name: 'Mascara Decorativa de Madera',
    price: 45.20,
    description: 'Máscara de madera tallada y pintada a mano, representando una figura cultural. Un toque exótico para tu hogar.',
    imageUrl: 'https://i.postimg.cc/63vbcpZt/mascara.png',
  },
  {
    id: '4',
    name: 'Juego de Joyería de Plata',
    price: 120.00,
    description: 'Elegante juego de collar y aretes en plata de ley, con incrustaciones de piedras semipreciosas. Ideal para prendas de moda.',
    imageUrl: 'https://i.postimg.cc/T1vg6R4d/joyeriaplata.jpg',
  },

  {
    id: '5',
    name: 'Lámpara de Mimbre',
    price: 65.60,
    description: 'Lámpara colgante hecha a mano con fibras naturales de mimbre, aporta un estilo rústico y acogedor a cualquier ambiente.',
    imageUrl: 'https://i.postimg.cc/nhMz3XHy/lampara.png',
  },

  {
    id: '6',
    name: 'Cuadro Textil Huichol',
    price: 90.30,
    description: 'Cuadro decorativo con arte textil Huichol, lleno de colores vivos y detalles elaborados a mano. Perfecto para coleccionistas.',
    imageUrl: 'https://i.postimg.cc/cJnf59xG/cuadro.png',
  },
];

export const getProductById = (id) => products.find(product => product.id === id);
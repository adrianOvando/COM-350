const mongoose = require('mongoose');

// Usar la variable de entorno MONGO_URI
const mongoUri = process.env.MONGO_URI || 'mongodb://mongo:27017/bd_usuarios';

mongoose.connect(mongoUri)
  .then(() => console.log('Conectado a MongoDB'))
  .catch(error => console.error('Error al conectar a MongoDB:', error));
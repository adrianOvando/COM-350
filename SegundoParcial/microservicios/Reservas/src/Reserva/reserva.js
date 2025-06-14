const mongoose = require('mongoose');

const reservaSchema = new mongoose.Schema({
  habitacion_id: { type: mongoose.Schema.Types.ObjectId, ref: 'Habitacion', required: true },
  usuario_id: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  fecha_reserva: { type: Date, default: Date.now },
  fecha_entrada: { type: Date, required: true },
  fecha_salida: { type: Date, required: true },
  estado_reserva: { type: String, enum: ['pendiente', 'confirmada', 'cancelada'], default: 'pendiente' },
  total_pagar: { type: Number, required: true }
});

module.exports = mongoose.model('Reserva', reservaSchema);

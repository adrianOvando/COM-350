const express = require('express');
const router = express.Router();
const bodyParser = require('body-parser');
const VerifyToken = require('./VerifyToken');
const Reserva = require('../Reserva/reserva');
const logger = require('../config/log');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());

// Crear una nueva reserva
router.post('/reservas', VerifyToken, async (req, res) => {
  try {
    const reserva = new Reserva(req.body);
    await reserva.save();
    res.status(201).json(reserva);
  } catch (error) {
    res.status(400).json({ message: 'Error al crear reserva', error });
  }
});

// Listar todos reservas
router.get('/reservas', VerifyToken, async (req, res) => {
  try {
    const reservas = await Reserva.find().exec();
    res.status(200).send(reservas);
    logger.info("Lista de reservas enviada");
  } catch (error) {
    logger.error("Error al listar reservas: ", error);
    res.status(500).json({ message: "Error al listar reservas", error });
  }
});


// Obtener una reserva por ID
router.get('/reservas/:id', VerifyToken, async (req, res) => {
  try {
    const reserva = await Reserva.findById(req.params.id).populate('habitacion_id usuario_id');
    if (!reserva) return res.status(404).json({ message: 'Reserva no encontrada' });
    res.json(reserva);
  } catch (error) {
    res.status(500).json({ message: 'Error al buscar la reserva', error });
  }
});

// Actualizar una reserva
router.put('/reservas/:id', VerifyToken, async (req, res) => {
  try {
    const reserva = await Reserva.findByIdAndUpdate(req.params.id, req.body, { new: true });
    if (!reserva) return res.status(404).json({ message: 'Reserva no encontrada' });
    res.json(reserva);
  } catch (error) {
    res.status(400).json({ message: 'Error al actualizar la reserva', error });
  }
});

// Eliminar una reserva
router.delete('/reservas/:id', VerifyToken, async (req, res) => {
  try {
    const result = await Reserva.findByIdAndDelete(req.params.id);
    if (!result) return res.status(404).json({ message: 'Reserva no encontrada' });
    res.json({ message: 'Reserva eliminada' });
  } catch (error) {
    res.status(500).json({ message: 'Error al eliminar la reserva', error });
  }
});

module.exports = router;

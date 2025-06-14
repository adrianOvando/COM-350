var VerifyToken= require('./VerifyToken');
var dbConnection = require('../../config/dbConnection').pool;
var logger = require('../../config/log');
var dateFormat = require('dateformat');


module.exports = app => {
    app.use(function (item, req, res, next) {
        console.log(item);
        res.status(200).send(item);
    });
    //cloudinary.config(secrets.cloudinary);
    /* GET items listing. */
    app.get('/api/v1/habitaciones', VerifyToken, (req, res) => {
        logger.info("GET: /api/v1/habitaciones");
        const sql = "SELECT id, Nombre, description, price FROM habitacion";
        dbConnection.getConnection((err, connection) => {
            if (err) return res.status(500).json({ error: err });
            connection.query(sql, (err, result) => {
                connection.release();
                if (err) return res.status(500).json({ error: err });
                res.json(result);
            });
        });
    });
    /* GET a item. */
    app.get('/api/v1/habitaciones/:id', VerifyToken, (req, res) => {
        logger.info("GET: /api/v1/habitaciones/:id");
        const sql = "SELECT id, Nombre, description, price FROM habitacion WHERE id = ?";
        dbConnection.getConnection((err, connection) => {
            if (err) return res.status(500).json({ error: err });
            connection.query(sql, [req.params.id], (err, result) => {
                connection.release();
                if (err) return res.status(500).json({ error: err });
                res.json(result[0] || {});
            });
        });
    });
    /* POST item creating. */
    app.post('/api/v1/habitaciones', VerifyToken, (req, res) => {
        const { Nombre, description, price } = req.body;
        const sql = "INSERT INTO habitacion (Nombre, description, price) VALUES (?, ?, ?)";
        dbConnection.getConnection((err, connection) => {
            if (err) return res.status(500).json({ error: err });
            connection.query(sql, [Nombre, description, price], (err, result) => {
                connection.release();
                if (err) return res.status(500).json({ error: err });
                res.json({ message: 'Habitación creada', id: result.insertId });
            });
        });
    });
    /* PUT item updating. */
    app.put('/api/v1/habitaciones/:id', VerifyToken, (req, res) => {
        const { Nombre, description, price } = req.body;
        const sql = "UPDATE habitacion SET Nombre = ?, description = ?, price = ? WHERE id = ?";
        dbConnection.getConnection((err, connection) => {
            if (err) return res.status(500).json({ error: err });
            connection.query(sql, [Nombre, description, price, req.params.id], (err, result) => {
                connection.release();
                if (err) return res.status(500).json({ error: err });
                res.json({ message: 'Habitación actualizada' });
            });
        });
    });
    /* DELETE item. */
    app.delete('/api/v1/habitaciones/:id', VerifyToken, (req, res) => {
        const sql = "DELETE FROM habitacion WHERE id = ?";
        dbConnection.getConnection((err, connection) => {
            if (err) return res.status(500).json({ error: err });
            connection.query(sql, [req.params.id], (err, result) => {
                connection.release();
                if (err) return res.status(500).json({ error: err });
                res.json({ message: 'Habitación eliminada' });
            });
        });
    });
    /* PATCH item. */
};
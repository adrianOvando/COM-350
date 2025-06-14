var express = require('express');

var app = express();


 var db =  require('./config/db');



var ReservaController = require('./routes/reservaRoutes');

app.use('/api/v1/reservas', ReservaController);

module.exports = app;
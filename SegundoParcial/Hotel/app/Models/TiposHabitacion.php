<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class TiposHabitacion extends Model
{
    /** @use HasFactory<\Database\Factories\TiposHabitacionFactory> */
    use HasFactory;
    protected $table = 'tipos_habitacions';
    protected $fileable = [
        'nombre',
        'descripcion',
        'precio_tipo_habitacion',
        'habitacions_id',
    ];
    public function habitacion()
    {
        return $this->belongsTo(Habitacion::class, 'habitacions_id');
    }
}

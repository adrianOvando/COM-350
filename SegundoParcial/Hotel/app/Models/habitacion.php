<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class habitacion extends Model
{
    /** @use HasFactory<\Database\Factories\HabitacionFactory> */
    use HasFactory;
    protected $fillable = [
        'numero_habitacion',
        'descripcion',
        'precio_habitacion',
        'disponibilidad',
        'tipo_habitacion_id',
    ];  
    public function tipoHabitacion()
    {
        return $this->belongsTo(tiposhabitacion::class, 'tipo_habitacion_id');
    }
}

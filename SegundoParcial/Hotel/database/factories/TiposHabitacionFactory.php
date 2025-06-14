<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\TiposHabitacion;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\tipos_habitacion>
 */
class TiposHabitacionFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */

    protected $model = TiposHabitacion::class;

    public function definition(): array
    {
        
        return [
            'nombre' => $this->faker->unique()->word,
            'descripcion' => $this->faker->sentence,
            'precio_tipo_habitacion' => $this->faker->randomFloat(2, 50, 500),
            'habitacions_id' => \App\Models\Habitacion::factory(), 
        ];
    }
}

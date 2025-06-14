<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\TiposHabitacion;
use App\Models\Habitacion;
/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\habitacion>
 */
class HabitacionFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    protected $model = Habitacion::class;

    public function definition(): array
    {
        return [
            'numero_habitacion' => $this->faker->unique()->numberBetween(100, 999),
            'descripcion' => $this->faker->sentence,
            'precio_por_noche' => $this->faker->randomFloat(2, 50, 500),
            'estado' => $this->faker->randomElement(['disponible', 'ocupada', 'mantenimiento']),
            'tipo_habitacion' => $this->faker->randomElement(['individual', 'doble', 'suite'])
        ];
    }
}

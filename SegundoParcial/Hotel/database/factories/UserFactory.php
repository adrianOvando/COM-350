<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\User>
 */
class UserFactory extends Factory
{
    /**
     * The current password being used by the factory.
     */
    protected static ?string $password;

    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    protected $model = \App\Models\User::class;
    public function definition(): array
    {
        return [
            'name' => fake()->name,
            'email' => fake()->unique()->safeEmail,
            'email_verified_at' => now(),
            'password' => bcrypt('password'), 
            'remember_token' => Str::random(10),
            'telefono' => fake()->phoneNumber,
            'direccion' => fake()->address,
            'role' => fake()->randomElement(['admin', 'client']),
        ];
    }

    /**
     * Indicate that the model's email address should be unverified.
     */
    
}

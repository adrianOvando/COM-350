<?php 

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Seeder;
use App\Models\habitacion;
use App\Models\TiposHabitacion;
use Illuminate\Support\Facades\Hash;


class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
     public function run()
    {
        \App\Models\User::create([
        'name' => 'Admin',
        'email' => 'admin@example.com',
        'password' => Hash::make('123'), 
        'telefono' => '123456789',
        'direccion' => 'Oficina central',
        'role' => 'admin', 
        ]);
        User::factory(10)->create();

        $habitaciones = Habitacion::factory(10)->create([
            'tipo_habitacion' => 'individual'
        ]);
        $habitaciones = Habitacion::factory(5)->create([
            'tipo_habitacion' => 'doble'
        ]);
        $habitaciones = Habitacion::factory(5)->create([
            'tipo_habitacion' => 'triple'
        ]);
        $habitaciones = Habitacion::factory(8)->create([
            'tipo_habitacion' => 'matrimoniales'
        ]);

        foreach ($habitaciones as $habitacion) {
            TiposHabitacion::factory()->create([
                'habitacions_id' => $habitacion->id,
            ]);
        }
    }
}

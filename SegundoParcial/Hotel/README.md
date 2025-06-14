# CRear Modelo, migracion, controlador, resorce, factory y seeder
php artisan make:model Producto -mcrfs

## mdelos
php artisan make:model Member
php artisan make:model Trainer
php artisan make:model Payment
php artisan make:model Attendance
php artisan make:model WorkoutSchedule

## recursos de Filament (equivalentes a controladores+views)
php artisan make:filament-resource Member
php artisan make:filament-resource Trainer
php artisan make:filament-resource Payment
php artisan make:filament-resource Attendance
php artisan make:filament-resource WorkoutSchedule

# Borrala base de datos hace correr todas las migraciones y los seeders declarados en el database seeder 

php artisan migrate:fresh --seed

## factories 
# Users
php artisan make:factory UserFactory --model=User

# Members (socios)
php artisan make:factory MemberFactory --model=Member

# Trainers (entrenadores - aunque en tu caso están en la tabla users)
php artisan make:factory TrainerFactory --model=User  # Porque los trainers son users con role='trainer'

# Attendances (asistencias)
php artisan make:factory AttendanceFactory --model=Attendance

# Payments (pagos)
php artisan make:factory PaymentFactory --model=Payment

# WorkoutSchedules (horarios de entrenamiento)
php artisan make:factory WorkoutScheduleFactory --model=WorkoutSchedule

## Seeders

# Usuarios base (admin, trainer, receptionist, member)
php artisan make:seeder UsersTableSeeder

# Socios (Members)
php artisan make:seeder MembersTableSeeder

# Asistencias (Attendances)
php artisan make:seeder AttendancesTableSeeder

# Pagos (Payments)
php artisan make:seeder PaymentsTableSeeder

# Horarios de entrenamiento (WorkoutSchedules)
php artisan make:seeder WorkoutSchedulesTableSeeder


## comando para que te genere routes/filament (modificar rutas y demas cosas)
php artisan vendor:publish --tag=filament-routes

## php artisan vendor:publish --tag=filament-views
para modificar el login de filament publicar sus vistas

## instalar filament
composer require filament/filament:"^3.3" -W

## crear paneles
php artisan make:filament-panel Admin

## para hacer correr

php artisan serve

npm run dev



<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GymRat - Login</title>
    @vite(['resources/css/app.css', 'resources/js/app.js'])
    <style>
        .bg-gym-gradient {
            background: linear-gradient(135deg, #1a2e1a 0%, #0d0d0d 100%);
        }
        .border-gym {
            border-color: #2d5a2d;
        }
        .focus-gym:focus {
            ring-color: #3a7a3a;
            border-color: #3a7a3a;
        }
    </style>
</head>
<body class="bg-gym-gradient h-screen flex items-center justify-center">
    <div x-data="{ shake: false }" class="bg-gray-900 p-8 rounded-xl shadow-lg w-full max-w-md transition-all duration-300 ease-in-out hover:shadow-xl transform hover:-translate-y-1 border border-gym">
        <div class="text-center mb-6">
            <img src="{{ asset('images/logo.png') }}" class="w-24 h-24 mx-auto mb-4">
            <h1 class="text-3xl font-bold text-green-500 mb-2">GymRat</h1>
            <p class="text-gray-400">Sistema de gestión deportiva</p>
            <div class="h-1 w-16 bg-green-600 mx-auto rounded-full mt-2"></div>
        </div>
        
        <form method="POST" action="{{ route('login') }}" class="space-y-6">
            @csrf
            <div class="space-y-2 group">
                <label for="email" class="block text-sm font-medium text-gray-300 group-focus-within:text-green-400 transition-colors duration-200">Email:</label>
                <input type="email" name="email" id="email" required 
                       class="w-full px-4 py-3 bg-gray-800 text-gray-200 border-2 border-gym rounded-lg shadow-sm focus:outline-none focus:ring-2 focus-gym focus:border-gym transition-all duration-200">
            </div>
            
            <div class="space-y-2 group">
                <label for="password" class="block text-sm font-medium text-gray-300 group-focus-within:text-green-400 transition-colors duration-200">Contraseña:</label>
                <input type="password" name="password" id="password" required 
                       class="w-full px-4 py-3 bg-gray-800 text-gray-200 border-2 border-gym rounded-lg shadow-sm focus:outline-none focus:ring-2 focus-gym focus:border-gym transition-all duration-200">
            </div>
            
            <div class="flex items-center justify-between">
                <div class="flex items-center">
                    <input id="remember" name="remember" type="checkbox" class="h-4 w-4 text-green-600 focus:ring-green-500 border-gray-600 rounded bg-gray-800">
                    <label for="remember" class="ml-2 block text-sm text-gray-400">Recordarme</label>
                </div>
                
                <div class="text-sm">
                    <a href="{{ route('password.request') }}" class="font-medium text-green-500 hover:text-green-400">¿Olvidaste tu contraseña?</a>
                </div>
            </div>
            
            <div class="pt-2">
                <button type="submit" 
                        class="w-full flex justify-center py-3 px-4 border border-transparent rounded-lg text-sm font-semibold text-white bg-green-600 hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-500 transition-all duration-200 transform hover:scale-105"
                        @click="shake = true; setTimeout(() => shake = false, 1000)">
                    Entrar al sistema
                </button>
            </div>
        </form>

        <div id="error-message" class="mt-6 text-center" :class="{'animate-pulse': shake}">
            @if($errors->any())
                <p class="text-red-400 text-sm">{{ $errors->first() }}</p>
            @endif
        </div>
    </div>
</body>
</html>
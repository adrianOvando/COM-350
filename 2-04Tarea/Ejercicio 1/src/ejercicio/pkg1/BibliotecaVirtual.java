/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg1;

/**
 *
 * @author Adrian
 */
public class BibliotecaVirtual {

    public static void main(String[] args){
                // Crear un libro a través del proxy
        Libro libroProxy = new ProxyLibro(
                "El Principito",
                "Antoine de Saint-Exupery",
                1943,
                "Erase una vez un principito que vivia en un planeta apenas mas grande que el..."
        );

        // Acceder al libro a través del proxy
        libroProxy.leer();

        Libro otroLibro = new ProxyLibro(
                "Cien anios de soledad",
                "Gabriel Garcia Marquez",
                1967,
                "Muchos anios despues, frente al peloton de fusilamiento, Aureliano Buendia..."
        );

        System.out.println("\n\nAccediendo a otro libro:");
        otroLibro.leer();
    }
    
}

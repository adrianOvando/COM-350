/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg1;

/**
 *
 * @author Adrian
 */
public class LibroReal implements Libro{
        private String titulo;
    private String autor;
    private int año;
    private String contenido;

    public LibroReal(String titulo, String autor, int año, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.contenido = contenido;
    }

    @Override
    public void leer() {
        System.out.println("\n--- Contenido del Libro ---");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Anio: " + año);
        System.out.println("\nContenido:");
        System.out.println(contenido);
        System.out.println("---------------------------\n");
    }
}

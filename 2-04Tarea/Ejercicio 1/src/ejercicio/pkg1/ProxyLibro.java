/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg1;

/**
 *
 * @author Adrian
 */
public class ProxyLibro implements Libro {
    private LibroReal libroReal;
    private String titulo;
    private String autor;
    private int año;
    private String contenido;

    public ProxyLibro(String titulo, String autor, int año, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.contenido = contenido;
    }

    @Override
    public void leer() {
        if (libroReal == null) {
            libroReal = new LibroReal(titulo, autor, año, contenido);
        }
        
        System.out.println("Verificando permisos...");
        System.out.println("Acceso permitido al libro: " + titulo);
        libroReal.leer();
    }
}
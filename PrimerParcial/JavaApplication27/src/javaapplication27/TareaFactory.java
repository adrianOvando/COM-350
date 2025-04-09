/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;

/**
 *
 * @author Adrian
 */
public class TareaFactory {
    public static Tarea crearTarea(String tipo, String descripcion) {
        switch (tipo.toLowerCase()) {
            case "simple":
                return new TareaSimple(descripcion);
            case "compuesta":
                return new TareaCompuesta(descripcion);
            default:
                throw new IllegalArgumentException(""); //inge no me funciona si no pongo esto me muestra error
        }
    }
}
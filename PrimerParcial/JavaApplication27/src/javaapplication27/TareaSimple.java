/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;

/**
 *
 * @author Adrian
 */
public class TareaSimple implements Tarea {
    private String descripcion;

    public TareaSimple(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getDescripcion() {
        return "[Simple] " + descripcion;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando: " + getDescripcion());
    }
}
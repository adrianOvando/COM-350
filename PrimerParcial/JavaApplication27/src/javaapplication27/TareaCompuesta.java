/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Adrian
 */
public class TareaCompuesta implements Tarea {
    private String descripcion;
    private List<Tarea> subtareas = new ArrayList<>();

    public TareaCompuesta(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarSubtarea(Tarea tarea) {
        subtareas.add(tarea);
    }

    @Override
    public String getDescripcion() {
        return "[Compuesta] " + descripcion + " (" + subtareas.size() + " subtareas)";
    }

    @Override
    public void ejecutar() {
        System.out.println("Iniciando: " + getDescripcion());
        for (Tarea tarea : subtareas) {
            tarea.ejecutar();  // recursividad para que este ejucute las subs
        }
    }
}

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
public class GestorTareasFacade {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void mostrarTareas() {
        System.out.println("\n lista de todas las tareas");
        for (Tarea tarea : tareas) {
            System.out.println(tarea.getDescripcion());
        }
    }

    public void ejecutarTodas() {
        System.out.println("\n Tareas ejecutadads ");
        for (Tarea tarea : tareas) {
            tarea.ejecutar();
        }
    }
}

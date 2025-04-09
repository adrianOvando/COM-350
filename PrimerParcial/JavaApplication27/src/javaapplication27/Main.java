/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication27;

import java.util.Scanner;
/**
 *
 * @author Adrian
 */

public class Main {
    public static void main(String[] args) {
        GestorTareasFacade gestor = new GestorTareasFacade();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Crear Tarea Simple");
            System.out.println("2. Crear Tarea Compuesta");
            System.out.println("3. Mostrar Tareas");
            System.out.println("4. Ejecutar Todas las Tareas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la tarea simple: ");
                    String descSimple = scanner.nextLine();
                    Tarea simple = TareaFactory.crearTarea("simple", descSimple);
                    gestor.agregarTarea(simple);
                    break;
                case 2:
                    System.out.print("Descripcion de la tarea compuesta: ");
                    String descCompuesta = scanner.nextLine();
                    TareaCompuesta compuesta = (TareaCompuesta) TareaFactory.crearTarea("compuesta", descCompuesta);
                    System.out.print("¿Cuántas subtareas agregara?: ");
                    int numSubtareas = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numSubtareas; i++) {
                        System.out.print("Descripcion de la subtarea " + (i + 1) + ": ");
                        String descSubtarea = scanner.nextLine();
                        compuesta.agregarSubtarea(new TareaSimple(descSubtarea));
                    }
                    gestor.agregarTarea(compuesta);
                    break;
                case 3:
                    gestor.mostrarTareas();
                    break;
                case 4:
                    gestor.ejecutarTodas();
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }
}

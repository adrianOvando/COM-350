/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Adrian
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaVentasFacade sistema = new SistemaVentasFacade();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MINISUPERMERCADO ---");
            System.out.println("1. Iniciar nueva venta");
            System.out.println("2. Agregar producto");
            System.out.println("3. Finalizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    sistema.iniciarNuevaVenta();
                    break;
                case 2:
                    sistema.agregarProducto();
                    break;
                case 3:
                    sistema.finalizarVenta();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
    }
}
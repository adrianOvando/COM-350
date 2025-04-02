/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class SistemaVentasFacade {
    private List<Producto> productosDisponibles = new ArrayList<>();
    private Venta ventaActual;
    private Scanner scanner = new Scanner(System.in);

    public SistemaVentasFacade() {
        inicializarProductos();
    }

    private void inicializarProductos() {
        // Productos simples
        ProductoSimple leche = new ProductoSimple("Leche entera 1L", 2.50);
        ProductoSimple pan = new ProductoSimple("Pan blanco", 1.20);
        ProductoSimple huevos = new ProductoSimple("Huevos (docena)", 3.75);
        ProductoSimple arroz = new ProductoSimple("Arroz 1kg", 1.80);

        // Producto compuesto (paquete básico)
        ProductoCompuesto paqueteBasico = new ProductoCompuesto("Paquete basico alimenticio");
        paqueteBasico.agregarProducto(leche);
        paqueteBasico.agregarProducto(pan);
        paqueteBasico.agregarProducto(huevos);

        productosDisponibles.add(leche);
        productosDisponibles.add(pan);
        productosDisponibles.add(huevos);
        productosDisponibles.add(arroz);
        productosDisponibles.add(paqueteBasico);
    }

    public void iniciarNuevaVenta() {
        ventaActual = new Venta();
        System.out.println("\n--- NUEVA VENTA ---");
        System.out.print("Nombre del cliente: ");
        ventaActual.setNombreCliente(scanner.nextLine());
        System.out.print("Tipo documento (CI/CU): ");
        ventaActual.setTipoDocumento(scanner.nextLine());
        System.out.print("Número documento: ");
        ventaActual.setNumeroDocumento(scanner.nextLine());
        ventaActual.setFecha(new Date());
    }

    public void agregarProducto() {
        if (ventaActual == null) {
            System.out.println("Primero debe iniciar una nueva venta");
            return;
        }

        System.out.println("\nProductos disponibles:");
        for (int i = 0; i < productosDisponibles.size(); i++) {
            System.out.printf("%d. %-30s $%,.2f%n", 
                i + 1, 
                productosDisponibles.get(i).getDescripcion(), 
                productosDisponibles.get(i).getPrecio());
        }

        System.out.print("Seleccione producto (numero): ");
        int opcion = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        DetalleVenta detalle = new DetalleVenta(
            productosDisponibles.get(opcion), 
            cantidad);
        
        ventaActual.agregarDetalle(detalle);
        System.out.println("Producto agregado a la venta");
    }

    public void finalizarVenta() {
        if (ventaActual == null || ventaActual.getDetalles().isEmpty()) {
            System.out.println("No hay venta en curso o no tiene productos");
            return;
        }

        System.out.println("\n--- FINALIZAR VENTA (Numero)--- ");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta de crédito");
        System.out.println("3. Transferencia bancaria");
        System.out.print("Seleccione forma de pago: ");
        int opcionPago = Integer.parseInt(scanner.nextLine());

        switch (opcionPago) {
            case 1:
                ventaActual.setTipoPago("Efectivo");
                break;
            case 2:
                ventaActual.setTipoPago("Tarjeta de credito");
                break;
            case 3:
                ventaActual.setTipoPago("Transferencia bancaria");
                break;
        }

        // Usando el patrón Factory para procesar el pago
        Pago pago = FabricaPago.crearPago(ventaActual.getTipoPago().toLowerCase());
        pago.procesarPago(ventaActual.getTotal());

        ventaActual.mostrarDetalle();
        ventaActual = null;
    }
}

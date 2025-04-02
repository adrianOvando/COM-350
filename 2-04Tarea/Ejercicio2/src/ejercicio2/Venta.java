/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Venta {

    private String nombreCliente;
    private Date fecha;
    private String tipoDocumento;
    private String numeroDocumento;
    private List<DetalleVenta> detalles = new ArrayList<>();
    private String tipoPago;

    public Venta() {
        this.fecha = new Date(); 
    }

    public Venta(String nombreCliente, Date fecha, String tipoDocumento, String numeroDocumento, String tipoPago) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.tipoPago = tipoPago;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Venta{" + "nombreCliente=" + nombreCliente + ", fecha=" + fecha + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", detalles=" + detalles + ", tipoPago=" + tipoPago + '}';
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double getTotal() {
        return detalles.stream().mapToDouble(DetalleVenta::getSubtotal).sum();
    }

    public void mostrarDetalle() {
        System.out.println("\n--- DETALLE DE VENTA ---");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Documento: " + tipoDocumento + " " + numeroDocumento);
        System.out.println("Fecha: " + fecha);
        System.out.println("\nDetalles:");
        detalles.forEach(System.out::println);
        System.out.println("\nTOTAL: $" + String.format("%,.2f", getTotal()));
        System.out.println("Forma de pago: " + tipoPago);
        System.out.println("------------------------");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Adrian
 */
public class TarjetaCredito implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta de crédito por $" + String.format("%,.2f", monto));
    }
}

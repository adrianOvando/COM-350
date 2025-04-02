/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Adrian
 */
public class TransferenciaBancaria implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Transferencia bancaria por $" + String.format("%,.2f", monto));
    }
}
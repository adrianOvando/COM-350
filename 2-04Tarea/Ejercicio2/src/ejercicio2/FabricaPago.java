/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Adrian
 */
public class FabricaPago {
    public static Pago crearPago(String tipo) {
        switch (tipo.toLowerCase()) {
            case "efectivo":
                return new Efectivo();
            case "tarjeta":
                return new TarjetaCredito();
            case "transferencia":
                return new TransferenciaBancaria();
            default:
                throw new IllegalArgumentException("Tipo de pago no válido");
        }
    }
}


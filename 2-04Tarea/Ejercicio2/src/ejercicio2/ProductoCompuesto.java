/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class ProductoCompuesto implements Producto {
    private String descripcion;
    private List<Producto> productos = new ArrayList<>();

    public ProductoCompuesto(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String getDescripcion() {
        return descripcion + " (Paquete)";
    }

    @Override
    public double getPrecio() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}

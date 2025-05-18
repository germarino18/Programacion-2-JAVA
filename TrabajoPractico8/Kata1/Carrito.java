package Kata1;

import java.util.ArrayList;
import java.util.List;

public class Carrito <T extends Producto<?>>{
    private List<T> productos;

    public Carrito(){
        productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    public void eliminarProducto(T producto) {
        productos.remove(producto);
    }

    public double obtenerTotal() {
        double total = 0.0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Contenido del carrito:");
            for (T producto : productos) {
                System.out.println(producto);
            }
        }
    }
}

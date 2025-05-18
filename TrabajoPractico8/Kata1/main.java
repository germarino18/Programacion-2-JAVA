package Kata1;

import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Carrito<Producto<?>> carrito = new Carrito<>();
        List<Producto<?>> productos = new ArrayList<>();

        productos.add(new Producto<String>("SKU231", "Cacao", 1500.00));
        productos.add(new Producto<Integer>(432, "Yerba", 1000.00));
        productos.add(new Producto<String>("SKU533", "Azucar", 2000.00));
        productos.add(new Producto<Integer>(553, "Gelatina", 2500.00));

        for (Producto<?> producto : productos){
            System.out.println(producto);
        }

        Producto<String> prod1 = new Producto<>("SKU001", "Pan", 100.0);
        Producto<Integer> prod2 = new Producto<>(2002, "Leche", 180.0);
        Producto<String> prod3 = new Producto<>("SKU009", "Queso", 320.5);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        carrito.mostrarProductos();
        System.out.println("Total del carrito: $" + carrito.obtenerTotal());

        carrito.eliminarProducto(prod2); // Eliminar Leche

        System.out.println("\nDespués de eliminar un producto:");
        carrito.mostrarProductos();
        System.out.println("Total del carrito: $" + carrito.obtenerTotal());
    }
}

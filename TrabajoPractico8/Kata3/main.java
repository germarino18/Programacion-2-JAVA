package Kata3;

import Kata1.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Producto<String> prod1 = new Producto<>("SKU1", "Café", 150.0);
        Producto<String> prod2 = new Producto<>("SKU2", "Azúcar", 50.0);
        Producto<String> prod3 = new Producto<>("SKU3", "Leche", 80.0);
        Producto<String> prod4 = new Producto<>("SKU4", "Pan", 40.0);

        Pedido pedido1 = new Pedido(1, LocalDate.of(2025, 5, 10));
        pedido1.agregarProducto(prod1);
        pedido1.agregarProducto(prod2);

        Pedido pedido2 = new Pedido(2, LocalDate.of(2025, 5, 8));
        pedido2.agregarProducto(prod3);

        Pedido pedido3 = new Pedido(3, LocalDate.of(2025, 5, 12));
        pedido3.agregarProducto(prod4);
        pedido3.agregarProducto(prod2);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        System.out.println("Pedidos sin ordenar:");
        pedidos.forEach(System.out::println);

        // Ordenar por total (usando Comparable)
        Collections.sort(pedidos);
        System.out.println("\nPedidos ordenados por total:");
        pedidos.forEach(System.out::println);

        // Ordenar por fecha (usando Comparator)
        Collections.sort(pedidos, new ComparadorPedidosPorFecha());
        System.out.println("\nPedidos ordenados por fecha:");
        pedidos.forEach(System.out::println);
    }
    }


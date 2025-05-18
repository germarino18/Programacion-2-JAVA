package Kata4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(1, LocalDate.of(2025, 5, 10));
        Pedido pedido2 = new Pedido(2, LocalDate.of(2025, 5, 12));
        Pedido pedido3 = new Pedido(3, LocalDate.of(2025, 5, 15));

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        Buscador<Pedido, Integer> buscador = new Buscador<>();

        int idBuscado = 2;
        Pedido resultado = buscador.buscar(pedidos, idBuscado);

        if (resultado != null) {
            System.out.println("Pedido encontrado: " + resultado);
        } else {
            System.out.println("Pedido con ID " + idBuscado + " no encontrado.");
        }
    }
}


package Kata4;

import Kata1.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Identificable<Integer>{
    private int id;
    private List<Producto<?>> productos;
    private LocalDate fecha;

    public Pedido(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto<?> producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public boolean tieneMismoID(Integer id) {
        return this.id == id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + calcularTotal() +
                '}';
    }
}

package Kata1;

import java.util.ArrayList;

public class Pedido implements Pagable {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Cliente cliente;
    private String estado;

    //Constructor
    public Pedido(){}

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    //Getter y Setter
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public void agregarProducto(Producto prod){
        this.productos.add(prod);
    }

    public void cambiarEstado(String nuevoEstado){
        this.estado = nuevoEstado;
        cliente.notificar("Su pedido ha cmbiado de estado a: " + estado);
    }

    @Override
    public double calcularTotal(){
        double total = 0;
        for (Producto producto : productos){
            total += producto.calcularTotal();
        }
        return total;
    }


}

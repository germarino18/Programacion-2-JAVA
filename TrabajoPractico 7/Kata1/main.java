package Kata1;

public class main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        pedido.agregarProducto(new Producto("Alfajor", 1500));
        pedido.agregarProducto(new Producto("Gaseosa", 2500));
        pedido.agregarProducto(new Producto("Sanguche de jamon y queso", 2000));


        System.out.println("Total a pagar: $" + pedido.calcularTotal());

        System.out.println("");

        PagoConDescuento tarjeta = new TarjetaCredito("1234-3234-4323-6954");
        PagoConDescuento paypal = new PayPal("german@gmail.com");

        double monto = 500;
        double descuento = 10;

        tarjeta.procesarPago(monto * tarjeta.aplicarDescuento(descuento));
        paypal.procesarPago(monto * tarjeta.aplicarDescuento(descuento));


        System.out.println("");

        Cliente cliente = new Cliente("Jorge","jorge@gmail.com");
        Pedido pedido1 = new Pedido(cliente);

        pedido1.cambiarEstado("Enviado");
        pedido1.cambiarEstado("Entregado");
    }
}

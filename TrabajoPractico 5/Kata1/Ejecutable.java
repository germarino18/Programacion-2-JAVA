package Kata1;

public class Ejecutable {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Producto producto1 = new Producto("12", "Iphone 16", 1130000.00, 5, CategoriaProducto.ELECTRONICA);
        Producto producto2 = new Producto("23", "Heladera Samsung", 900000.50, 20, CategoriaProducto.HOGAR);
        Producto producto3 = new Producto("67", "Buzo Nike", 128000.90, 50, CategoriaProducto.ROPA);
        Producto producto4 = new Producto("26", "Papas Lays", 3500.0, 200, CategoriaProducto.ALIMENTOS);
        Producto producto5 = new Producto("13", "Samsung S20", 990000.00, 10, CategoriaProducto.ELECTRONICA);
        Producto producto6 = new Producto("33", "Xiaomi 30", 660000.00, 20, CategoriaProducto.ELECTRONICA);
        Producto producto7 = new Producto("37", "Barritas de cereal", 1000.00, 300, CategoriaProducto.ALIMENTOS);
        Producto producto8 = new Producto("39", "Pantalon Cargo", 25000.00, 150, CategoriaProducto.ROPA);
        Producto producto9 = new Producto("40", "Tostadora Eléctrica", 150000.00, 168, CategoriaProducto.HOGAR);

        /*KATA1
        Ejercicio 1 y 2
         */
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.listarProductos();
        System.out.println("");

        /*
        KATA2
        Ejercicio 1, 2, 3 y 4
         */
        inventario.agregarProducto(producto4);
        inventario.agregarProducto(producto5);
        inventario.agregarProducto(producto8);
        inventario.agregarProducto(producto9);
        inventario.buscarProductoPorId("26");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        inventario.eliminarProducto("12");
        inventario.listarProductos();
        System.out.println("");

        /*
        KATA3
        Ejercicio 1, 2, 3, 4 y 5
         */
        inventario.agregarProducto(producto7);
        inventario.obtenerTotalStock();
        inventario.obtenerProductoConMayorStock();
        inventario.filtrarProductosPorPrecio(1000.00, 3000.00);
        inventario.mostrarCategoriaDisponibles();

    }
}

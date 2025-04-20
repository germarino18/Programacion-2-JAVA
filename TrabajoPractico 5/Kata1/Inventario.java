package Kata1;

import java.awt.color.ICC_Profile;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    //Agrega un producto a la lista
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    //Muestra todos los productos del inventario
    public void listarProductos(){
        for (int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            System.out.println((i+1) + "- " +producto.getNombre()+
                    "\nCategoria: " +producto.getCategoria()+
                    "\nPrecio: $"+producto.getPrecio()+
                    "\nCantidad: "+producto.getCantidad());
        }
    }

    //Retorna un producto según su ID
    public void buscarProductoPorId(String id){
        Producto productoEncontrado = null;
        for (Producto producto : productos){
            if (producto.getId() == id){
                productoEncontrado = producto;
                break;
            }
        }
        if (productoEncontrado != null){
            System.out.println(productoEncontrado);
        }else{
            System.out.println("Producto no encontrado");
        }
    }

    //Elimina un producto por su ID
    public void eliminarProducto(String id){
        Producto productoEliminar = null;
        for (Producto producto : productos){
            if (producto.getId() == id){
                productoEliminar = producto;
                break;
            }
        }
        if (productoEliminar != null){
            productos.remove(productoEliminar);
        }else{
            System.out.println("No se encontró ningún producto con el ID proporcionado");
        }
    }

    //Actualiza la cantidad de un producto
    public void actualizarStock(String id, int nuevaCantidad){
        Producto productoActualizar = null;
        int cantidadActualizar;
        for (Producto producto : productos){
            if (producto.getId() == id){
                productoActualizar = producto;
                break;
            }
        }
        cantidadActualizar = productoActualizar.getCantidad()+nuevaCantidad;
        productoActualizar.setCantidad(cantidadActualizar);
    }

    // Devuelve una lista de productos según su categoría
    public void filtrarPorCategoria(CategoriaProducto categoria){
        System.out.println("Productos de la categoria: " +categoria);
        for (Producto producto : productos){
            if (producto.getCategoria() == categoria){
                System.out.println("- " +producto.getNombre()+
                        "\nPrecio: $" +producto.getPrecio()+
                        "\nCategoria: " +producto.getCategoria()+
                        "\nCantidad: " +producto.getCantidad());
            }
        }
    }

    //Devuelve la sumatoria de todas las cantidades de productos
    public void obtenerTotalStock(){
        int sumaTotal = 0;
        for (Producto producto : productos){
            sumaTotal += producto.getCantidad();
        }
        System.out.println("El total de las cantidades de productos es de: " +sumaTotal);
    }

    //Retorna el producto con mayor stock
    public void obtenerProductoConMayorStock(){
        Producto productoConMayorStock = null;
        int mayor = 0;
        for (Producto producto : productos){
            if (producto.getCantidad() > mayor){
                productoConMayorStock = producto;
                mayor = producto.getCantidad();
            }
        }
        System.out.println("El producto con mayor stock es: " +productoConMayorStock.getNombre());
    }

    //Devuelve los productos dentro de un rango de precios
    public void filtrarProductosPorPrecio(double min, double max){
        System.out.println("Productos entre el rangon de precio seleccionado: ");
        for (Producto producto : productos){
            if (min <= producto.getPrecio() && producto.getPrecio() <= max){
                System.out.println("- " +producto.getNombre()+ "\nPrecio: $" +producto.getPrecio());
            }
        }
    }

    //Muestra las categorías disponibles con su descripción
    public void mostrarCategoriaDisponibles(){
        System.out.println("Las categorias que tenemos disponibles son: " +
                "\n- Electronica: "+CategoriaProducto.ELECTRONICA.getDescripcion()+
                "\n- Ropa: " +CategoriaProducto.ROPA.getDescripcion()+
                "\n- Hogar: " +CategoriaProducto.HOGAR.getDescripcion()+
                "\n- Alimentos: " +CategoriaProducto.ALIMENTOS.getDescripcion());
    }
}

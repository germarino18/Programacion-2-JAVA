package org.example;

import java.util.Arrays;

import org.example.DAO.CategoriaDAOImpl;
import org.example.DAO.PedidoDAOImpl;
import org.example.DAO.ProductoDAOImpl;
import org.example.Service.CategoriaServiceImpl;
import org.example.Service.PedidoServiceImpl;
import org.example.Service.ProductoServiceImpl;
import org.example.model.Categoria;
import org.example.model.ItemPedido;
import org.example.model.Pedido;
import org.example.model.Producto;

public class Main {
    public static void main(String[] args) {
        
        //Creacion de las instancia del servicio y del DAO
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl();
        CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
        PedidoServiceImpl pedidoService = new PedidoServiceImpl();
        ProductoDAOImpl productoDAO = new ProductoDAOImpl();
        PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
        ProductoServiceImpl productoService = new ProductoServiceImpl();
    
        
        //Creacion de las categorias
        categoriaService.crear(Categoria.builder()
        .nombre("Comida")
        .descripcion("Comida consumible")
        .build());

        categoriaService.crear(Categoria.builder()
        .nombre("Bebida")
        .descripcion("Bebida consumible")
        .build());

        // Creación de productos con categorías
        Producto prod1 = Producto.builder()
                .nombre("Galletas")
                .precio(2.5)
                .cantidad(100)
                .descripcion("Galletas de chocolate")
                .categoria(categoriaDAOImpl.leer(1)) // Asignar una categoría existente
                .build();

        Producto prod2 = Producto.builder()
                .nombre("Gaseosa")
                .precio(2.5)
                .cantidad(100)
                .descripcion("Gaseosa de cola")
                .categoria(categoriaDAOImpl.leer(2)) // Asignar una categoría existente
                .build();

        productoService.crear(prod1);
        productoService.crear(prod2);
        
        // Seleccionar productos para el pedido
        Producto producto1 = productoDAO.leer(1); // Debe existir
        Producto producto2 = productoDAO.leer(2); // Debe existir
        Producto producto3 = productoDAO.leer(2); // Debe existir

        // Cargar items
        ItemPedido item1 = new ItemPedido();
        item1.setProducto(producto1);
        item1.setCantidad(2);

        ItemPedido item2 = new ItemPedido();
        item2.setProducto(producto2);
        item2.setCantidad(3);

        ItemPedido item3 = new ItemPedido();
        item3.setProducto(producto3);
        item3.setCantidad(200);

        // Creacion de pedidos
        Pedido pedido1 = new Pedido();
        pedido1.setItems(Arrays.asList(item1, item2));
        Pedido pedido2 = new Pedido();
        pedido2.setItems(Arrays.asList(item3)); 
        
        pedidoService.crear(pedido1);
        // Rollback automático si no hay stock
        pedidoService.crear(pedido2);

        // Mostrar los pedidos
        for (Pedido p : pedidoDAO.listar()) {
            pedidoService.mostrarDetallePedido(p.getId());
        }
        
        //Cerrando sesion
        pedidoDAO.closeSessionFactory();

    }
}
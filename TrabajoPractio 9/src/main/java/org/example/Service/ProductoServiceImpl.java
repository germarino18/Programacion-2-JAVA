package org.example.Service;

import org.example.DAO.CategoriaDAOImpl;
import org.example.DAO.ProductoDAOImpl;
import org.example.model.Producto;

public class ProductoServiceImpl implements GenericService<Producto>{

    private final ProductoDAOImpl productoDAO = new ProductoDAOImpl();
    private final CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl();

    @Override
    public boolean crear(Producto producto) {
        // Validar nombre no vacío
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return false;
        }
        // Validar precio > 0
        if (producto.getPrecio() <= 0) {
            System.out.println("El precio debe ser mayor a 0.");
            return false;
        }
        // Validar cantidad > 0
        if (producto.getCantidad() <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return false;
        }
        // Validar que la categoría exista
        if (producto.getCategoria() == null || categoriaDAO.leer(producto.getCategoria().getId()) == null) {
            System.out.println("La categoría especificada no existe.");
            return false;
        }
        // Si pasa todas las validaciones, crear el producto
        productoDAO.crear(producto);
        System.out.println("Producto creado correctamente.");
        return true;
    }
    
}

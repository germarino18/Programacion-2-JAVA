package org.example.Service;

import org.example.DAO.CategoriaDAOImpl;
import org.example.model.Categoria;

public class CategoriaServiceImpl implements GenericService<Categoria> {
    private final CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl();

    @Override
    public boolean crear(Categoria categoria) {
        // Validar campos vacíos
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío.");
            return false;
        }
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            System.out.println("La descripción de la categoría no puede estar vacía.");
            return false;
        }
        // Verificar que no exista una categoría con el mismo nombre
        if (categoriaDAO.existeNombre(categoria.getNombre())) {
            System.out.println("Ya existe una categoría con ese nombre.");
            return false;
        }
        // Si pasa las validaciones, crear la categoría
        categoriaDAO.crear(categoria);
        System.out.println("Categoría creada correctamente.");
        return true;
    }
}

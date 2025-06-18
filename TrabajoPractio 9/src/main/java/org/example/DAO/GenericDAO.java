package org.example.DAO;

import java.util.List;

public interface GenericDAO<T> {
    void crear(T entidad);
    T leer(int id);
    void actualizar(T entidad);
    void eliminar(int id);
    List<T> listar();
    boolean existeNombre(String nombre);
}

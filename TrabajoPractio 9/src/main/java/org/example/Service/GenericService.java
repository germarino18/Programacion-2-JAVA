package org.example.Service;

import org.example.model.Categoria;

public interface GenericService<T> {
    boolean crear(T entity);

    
}

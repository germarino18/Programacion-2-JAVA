package Kata1;

public enum CategoriaProducto{
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Atrículos para el hogar");

    private final String descripcion;

    CategoriaProducto(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    }


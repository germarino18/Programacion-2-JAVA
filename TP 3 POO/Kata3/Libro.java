package Kata3;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    //Constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int nuevoAnio) {
        if (nuevoAnio >= 1900 && nuevoAnio <= 2025){
            anioPublicacion = nuevoAnio;
        }else{
            System.out.println("No se puede modificar si el año es menor a 1900 o mayor al año actual.");
        }
    }


}

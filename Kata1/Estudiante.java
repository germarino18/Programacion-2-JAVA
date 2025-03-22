package Kata1;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    //Constructor
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void mostrarInfo(){
        System.out.println("Apellido: " +apellido+ "\nNombre: " +nombre+ "\nCurso: " +curso+ "\nCalificación: " +calificacion);
    }

    public void subirCalificacion(double puntos){
        if(puntos+calificacion <= 0){
            calificacion= 0.0;
        } else if (puntos+calificacion < 10) {
            calificacion+=puntos;
        } else{
            calificacion = 10.0;
        }
    }

    public void bajarCalificacion(double puntos){
        if (calificacion-puntos >= 10){
            calificacion = 10.0;
        } else if (calificacion-puntos >= 0) {
            calificacion-=puntos;
        } else{
            calificacion= 0.0;
        }
    }
}

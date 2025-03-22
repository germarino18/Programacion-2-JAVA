package Kata2;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;

    //Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " +nombre+ "\nEspecie: " +especie+ "\nEdad: " +edad);
    }

    public void cumplirAnios(){
        System.out.println("Ahora tu mascota tiene "+(edad+=1)+ " años");
    }
}

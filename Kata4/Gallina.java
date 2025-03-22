package Kata4;

public class Gallina {
    private String idGallina;
    private int edad;
    private int huevosPuestos;

    //Constructor
    public Gallina(String idGallina, int edad, int huevosPuestos) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }

    //Getter and Setter
    public String getIdGallina() {
        return idGallina;
    }

    public void setIdGallina(String idGallina) {
        this.idGallina = idGallina;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getHuevosPuestos() {
        return huevosPuestos;
    }

    public void setHuevosPuestos(int huevosPuestos) {
        this.huevosPuestos = huevosPuestos;
    }

    public void ponerHuevo(){
        this.huevosPuestos+=1;
        System.out.println("¡La gallina "+idGallina+ " ha puesto un huevo!");
    }

    public void envejecer(){
        edad+=1;
        System.out.println("La gallina "+idGallina+ " ha cumplido "+edad+ " años");
    }

    public void mostrarEstado(){
        System.out.println("Gallina: " +idGallina+ "\nEdad: " +edad+ "\nCantidad de huevos puestos: " +this.huevosPuestos);
    }
}

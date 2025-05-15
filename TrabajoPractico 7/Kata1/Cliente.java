package Kata1;

public class Cliente implements Notificable {
    private String nombre;
    private String email;

    //Constructor
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void notificar(String mensaje){
        System.out.println("Notificación para " + nombre + "(" + email + "): " + mensaje);
    }

}

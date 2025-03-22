package Kata4;

public class Ejecutable {
    public static void main(String[] args) {
        Gallina gallina1 = new Gallina("G001", 5, 10);
        Gallina gallina2 = new Gallina("G002", 10, 40);

        gallina1.ponerHuevo();
        gallina2.ponerHuevo();

        gallina1.envejecer();

        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
    }
}

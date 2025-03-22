package Kata5;

public class Ejecutable {
    public static void main(String[] args) {
        NaveEspacial nave1 = new NaveEspacial("Apolo 13", 50);

        nave1.avanzar(60);
        nave1.recargarCombustible(40);
        nave1.avanzar(60);
        nave1.mostrarEstado();
    }
}

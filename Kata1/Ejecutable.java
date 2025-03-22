package Kata1;

public class Ejecutable {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Germán", "Marino", "Programación", 7.5);


        estudiante1.mostrarInfo();

        estudiante1.subirCalificacion(2);
        System.out.println(estudiante1.getCalificacion());

        estudiante1.bajarCalificacion(3);
        System.out.println(estudiante1.getCalificacion());

    }
}

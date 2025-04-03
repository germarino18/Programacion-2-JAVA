package KATA1;

public class Ejecutable {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado(01, "German", 1500.00, "Desarrollo Web");
        Empleado empleado2 = new Empleado("Franco", "Ciberseguridad");
        Empleado empleado3 = new Empleado("Jesus", "Analista de Datos");

        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);

        empleado1.actualizarSalario();
        empleado2.actualizarSalario(20);
        System.out.println();

        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);

        Empleado.mostrarTotalEmpleados();
    }
}

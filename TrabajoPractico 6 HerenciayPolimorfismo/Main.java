//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        empresa.agregarEmpleado(new EmpleadoSalarioFijo("1234567", "Carlos", "Gonzalez", 2021, 45000));
        empresa.agregarEmpleado(new EmpleadoSalarioFijo("3453566", "Roberto", "Castro", 2019, 50000));
        empresa.agregarEmpleado(new EmpleadoAComision("3225664", "Josefina", "Cataneo", 2021, 30000, 100, 500));
        empresa.agregarEmpleado(new EmpleadoAComision("6642345", "Jose", "Blanco", 2014, 30000, 200, 100));

        empresa.mostrarSalarios();

        System.out.println(empresa.empleadoConMasClientes().nombreCompleto());
    }
}
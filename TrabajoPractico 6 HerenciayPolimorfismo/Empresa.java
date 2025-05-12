import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    //Constructor
    public Empresa() {
        this.empleados = empleados;
    }

    //Getter y Setter
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado e){
        empleados.add(e);
    }

    public void mostrarSalarios(){
        for (Empleado emp : empleados){
            System.out.println(emp.nombreCompleto() + ": $" + emp.getSalario());
        }
    }

    public Empleado empleadoConMasClientes() {
        int max = -1;
        Empleado elMayor = null;
        for (Empleado e : empleados){
            if (e instanceof EmpleadoAComision){
                EmpleadoAComision eac = (EmpleadoAComision) e;
                int cant = eac.getCantClientesCaptados();
                if (cant > max){
                    elMayor = eac;
                }
            }
        }
        return elMayor;
    }
}
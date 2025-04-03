package KATA1;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados;
    private static int contador;

    // CONSTRUCTORES

    public Empleado(int id, String nombre, double salario, String puesto) {
        contador++;
        Empleado.totalEmpleados = contador;
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.puesto = puesto;
    }

    public Empleado(String nombre, String puesto){
        contador++;
        Empleado.totalEmpleados = contador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 2000.00;
        id = contador;
    }

    //GETTERS y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }



    //METODOS
    public void actualizarSalario(int porcentajeAumento){
        if (porcentajeAumento < 0){
            salario = salario + 0;
        }else{
            this.salario = salario + (salario * porcentajeAumento/100);
        }
    }

    public void actualizarSalario(){
        int porcentajeFijoAumento = 15;
        this.salario = salario + (salario * porcentajeFijoAumento/100);
    }

    public static void mostrarTotalEmpleados(){
        System.out.println("El total de los empleados creados es de: " + Empleado.totalEmpleados);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=$" + salario +
                '}';
    }
}

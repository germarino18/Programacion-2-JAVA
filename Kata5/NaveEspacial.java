package Kata5;

public class NaveEspacial {
    private String nombre;
    private int combustible;

    //Constructor
    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    //Getter and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public void despegar(){
        if (combustible < 10){
            System.out.println("No puedes despegar la nave, debes cargar combustible!");
        }else{
            combustible-=10;
            System.out.println("Despegando... Has usado 10 unidades de combustible.");
        }
    }

    public void avanzar(int distancia){
      if (distancia <= combustible){
          System.out.println("Avanzando "+distancia+ " KM de distancia...");
          combustible-=distancia;
      }else{
          System.out.println("No se puede avanzar, no hay suficiente combustible para esa distancia.");
      }
    }

    public void recargarCombustible(int cantidad){
        if (cantidad <= 100){
            System.out.println("Cargando combustible...");
            combustible+=cantidad;
        }else{
            System.out.println("Solo puedes cargar hasta 100 unidades de combustible");
        }
    }

    public void mostrarEstado(){
        System.out.println("Nombre de la nave: " +nombre+ "\nCombustible actual: " +combustible);
    }
}

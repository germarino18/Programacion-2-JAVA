package Kata1;

public class TarjetaCredito implements PagoConDescuento {
    private String numeroTarjeta;

    //Constructor
    public TarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    //Getter y Setter
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double monto){
        System.out.println("Pago de $" + monto + " procesado con Tarjeta de Crédito " + numeroTarjeta);
    }

    @Override
    public double aplicarDescuento(double porcentaje){
        return 1 - (porcentaje / 100);
    }
}

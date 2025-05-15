package Kata2_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        try{
            System.out.println("Ingresa un número entero: ");
            String cadena = leer.nextLine();
            int numero = Integer.parseInt(cadena);
            System.out.println("Número ingresado: " + numero);
        } catch (NumberFormatException nfe){
            System.out.println("La entrada no es un número válido.");
        } finally {
            leer.close();
        }
    }
}

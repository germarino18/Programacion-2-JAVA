package Kata2_4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        try {
            System.out.println("Ingrese su edad: ");
            int edad = Integer.parseInt(leer.nextLine());
            if (edad < 0 || edad > 120){
                throw new EdadInvalidaException("Edad fuera de rango, tiene que estar entre 0 y 120");
            } else {
                System.out.println("Edad válida: " +edad);
            }
        } catch (EdadInvalidaException ex){
            System.out.println("Error: " + ex.getMessage());
        } finally {
            leer.close();
        }
    }
}

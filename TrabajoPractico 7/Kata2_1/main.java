package Kata2_1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int num1, num2;
        int resultado;
        try {
            System.out.println("Ingresa el primer número: ");
            num1 = Integer.parseInt(leer.nextLine());
            System.out.println("Ingresa el segundo número: ");
            num2 = Integer.parseInt(leer.nextLine());
            resultado = num1 / num2;
            System.out.println("El resultado de la división es: " + resultado);
        } catch (ArithmeticException ex){
            System.out.println("No se puede dividir por 0, ingresa otro número.");
        } finally {
            leer.close();
        }

    }
}

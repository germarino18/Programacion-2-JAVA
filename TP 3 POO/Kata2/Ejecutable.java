package Kata2;

import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String respuesta;

        Mascota mascota1 = new Mascota("Sol", "Canina", 5);

        mascota1.mostrarInfo();

        System.out.print("¿Tu mascota cumplió años? (SI/NO) ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("Si")){
            mascota1.cumplirAnios();
        }else{
        }
    }
}

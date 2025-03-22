package Kata3;


import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String respuesta;
        int nuevoAnio;

        Libro libro1 = new Libro("El extranjero", "Albert Camus", 1942);

        System.out.print("¿Deseas modificar el año de publicación? (SI/NO) ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("SI")) {
            System.out.print("Ingresa el nuevo año: ");
            nuevoAnio = Integer.parseInt(leer.nextLine());
            libro1.setAnioPublicacion(nuevoAnio);
        } else {
        }

        System.out.println("Nombre del libro: " +(libro1.getTitulo())+ "\nAutor: " +(libro1.getAutor())+ "\nAño de publicación: " +(libro1.getAnioPublicacion()));

    }
}
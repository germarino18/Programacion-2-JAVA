package Kata2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        try {
            File archivo = new File("archivo.txt");
            leer = new Scanner(archivo);

            while (leer.hasNextLine()){
                System.out.println(leer.nextLine());
            }
        } catch (FileNotFoundException fe){
            System.out.println("Error. El archivo no existe.");
        } finally {
            if (leer != null){
                leer.close();
            }
        }
    }
}

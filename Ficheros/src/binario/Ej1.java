package binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej1 {
    private static String ruta;
    private static String copia;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Ejercicio n° 1:
         * Escribir un programa Java que realice la copia de un fichero (por ejemplo un
         * fichero imagen). Se pide al usuario el fichero de entrada y el nombre del
         * fichero de salida.
         */
 
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo de entrada: ");
        String inputFile = scanner.nextLine();

        System.out.print("Introduce el nombre del archivo de salida: ");
        String outputFile = scanner.nextLine();

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("El archivo ha sido copiado exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

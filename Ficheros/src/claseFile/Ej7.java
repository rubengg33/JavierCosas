package claseFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Ej7 {

	public static void main(String[] args) {
        String nombreArchivo = "texto.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de líneas que deseas mostrar: ");
        int n = scanner.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;

            while ((linea = reader.readLine()) != null && contador < n) {
                System.out.println(linea);
                contador++;
            }

            if (contador < n) {
                System.out.println("El archivo contiene solo " + contador + " líneas.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
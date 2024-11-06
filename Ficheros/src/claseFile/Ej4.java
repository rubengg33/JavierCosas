package claseFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la palabra que quieres buscar: ");
        String palabra = scanner.nextLine();
        
        int contador = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("parrafo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir cada línea en palabras
                String[] palabras = linea.split("\\W+"); // Utiliza delimitadores no alfanuméricos
                for (String p : palabras) {
                    if (p.equalsIgnoreCase(palabra)) { // Ignora mayúsculas y minúsculas
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero: " + e.getMessage());
        }
        
        System.out.println("La palabra \"" + palabra + "\" aparece " + contador + " veces en el archivo 'parrafo.txt'.");
        scanner.close();
	}

}

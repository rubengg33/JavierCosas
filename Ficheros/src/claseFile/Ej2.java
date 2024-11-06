package claseFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Ej2 {
/*
 * Realizar un programa que cuente el número de líneas, caracteres y palabras que
tiene un fichero que se pasará por teclado.
Se debe comprobar que el fichero existe antes de empezar a contar.
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta del fichero: ");
        String rutaFichero = scanner.nextLine();
        
        File fichero = new File(rutaFichero);
        
        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El fichero no existe o no es un fichero válido.");
            scanner.close();
            return;
        }
        
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length();
                palabras += linea.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero: " + e.getMessage());
        }
        
        System.out.println("Número de líneas: " + lineas);
        System.out.println("Número de palabras: " + palabras);
        System.out.println("Número de caracteres: " + caracteres);
        
        scanner.close();
	}

}

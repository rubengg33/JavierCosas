package claseFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "texto.txt";
        String outputFile = "texto_encriptado.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            
            int c;
            while ((c = br.read()) != -1) {
                char caracterOriginal = (char) c;
                char caracterEncriptado = encriptarCaracter(caracterOriginal);
                bw.write(caracterEncriptado);
            }
            
            System.out.println("El archivo ha sido encriptado exitosamente. Contenido encriptado:");
            mostrarArchivo(outputFile);
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
    
    private static char encriptarCaracter(char c) {
        if (c >= 'a' && c <= 'z') { // Letras minúsculas
            return (char) ('a' + (c - 'a' + 3) % 26);
        } else if (c >= 'A' && c <= 'Z') { // Letras mayúsculas
            return (char) ('A' + (c - 'A' + 3) % 26);
        } else {
            return c; // Otros caracteres (como espacios y signos de puntuación) no se modifican
        }
    }
    
    private static void mostrarArchivo(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
	}

}

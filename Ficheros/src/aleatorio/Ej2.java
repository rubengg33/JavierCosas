package aleatorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej2 {

	 public static void main(String[] args) {
	        mostrarCalificaciones("calificaciones.txt");
	    }
	 public static void mostrarCalificaciones(String nombreArchivo) {
	        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
	            String linea;
	            System.out.println("Contenido del archivo '" + nombreArchivo + "':");
	            while ((linea = br.readLine()) != null) {
	                System.out.println(linea);
	            }
	        } catch (IOException e) {
	            System.out.println("Error de entrada/salida: " + e.getMessage());
	        }
	    }

	}

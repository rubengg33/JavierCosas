package claseFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1 {
	public static void main(String[] args) {
        String nombreArchivoEntrada = "texto.txt";
        String nombreArchivoSalida = "invertido.txt";

        try {
            // Leer el archivo de texto
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoEntrada));
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoSalida));

            String linea;
            while ((linea = reader.readLine()) != null) {
                // Invertir la línea
                String lineaInvertida = new StringBuilder(linea).reverse().toString();
                // Escribir la línea invertida en el archivo de salida
                writer.write(lineaInvertida);
                writer.newLine(); // Agregar nueva línea
            }

            // Cerrar los recursos
            reader.close();
            writer.close();

            // Mostrar el contenido del nuevo archivo
            mostrarContenidoArchivo(nombreArchivoSalida);
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }
    }

    private static void mostrarContenidoArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido de " + nombreArchivo + ":");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
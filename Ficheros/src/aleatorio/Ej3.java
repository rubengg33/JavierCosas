package aleatorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej3 {

	

    public static void main(String[] args) {
        actualizarCalificaciones("calificaciones.txt");
    }
    public static void actualizarCalificaciones(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();

        // Leer el archivo y almacenar las líneas
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return; // Salir del método en caso de error
        }

        // Actualizar las calificaciones
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                String[] partes = linea.split(" - ");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    double calificacion = Double.parseDouble(partes[1]);

                    // Actualizar calificaciones
                    if (calificacion > 8) {
                        calificacion = Math.min(calificacion + 1, 10); // Incrementar en 1, no superar 10
                    } else if (calificacion < 5) {
                        calificacion = Math.min(calificacion + 0.5, 5); // Incrementar en 0.5, no superar 5
                    }

                    // Escribir la línea actualizada en el archivo
                    bw.write(nombre + " - " + String.format("%.1f", calificacion));
                    bw.newLine();
                } else {
                    // En caso de formato incorrecto, se puede registrar o manejar
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
            System.out.println("Calificaciones actualizadas exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de las calificaciones: " + e.getMessage());
        }
    }
}


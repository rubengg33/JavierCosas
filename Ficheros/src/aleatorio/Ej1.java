package aleatorio;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Ej1 {
	
	public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Carlos");

        int[] calificaciones = {85, 90, 78};

        guardarCalificaciones(nombres, calificaciones, "calificaciones.txt");
    }
	public static void guardarCalificaciones(ArrayList<String> nombres, int[] calificaciones, String nombreArchivo) {
        if (nombres.size() != calificaciones.length) {
            System.out.println("La cantidad de nombres y calificaciones no coincide.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < nombres.size(); i++) {
                String linea = nombres.get(i) + " - " + calificaciones[i];
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Calificaciones guardadas exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
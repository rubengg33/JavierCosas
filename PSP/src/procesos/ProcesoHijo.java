package procesos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcesoHijo {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: ProcesoHijo <archivo de entrada> <archivo de salida>");
            System.exit(1); // argumentos insuficientes
        }

        String archivoEntrada = args[0];
        String archivoSalida = args[1];
        double sumaTotal = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(archivoEntrada))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    double cantidad = Double.parseDouble(linea.trim());
                    sumaTotal += cantidad;
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato numérico en línea: " + linea);
                }
            }

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(archivoSalida))) {
                writer.write("Total: " + sumaTotal);
            }
            System.exit(0); // todo salió bien

        } catch (FileNotFoundException e) {
            System.err.println("Archivo de entrada no encontrado: " + archivoEntrada);
            System.exit(2); // archivo no encontrado
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
            System.exit(3); // error de E/S
        }
    }
}

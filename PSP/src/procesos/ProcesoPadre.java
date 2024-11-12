package procesos;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProcesoPadre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directorio;
        while (true) {
            System.out.println("Introduce la ubicación del directorio:");
            directorio = scanner.nextLine();
            File folder = new File(directorio);
            if (folder.isDirectory() && folder.listFiles((dir, name) -> name.endsWith(".txt")).length > 0) {
                break;
            } else {
                System.out.println("Directorio no válido o vacío. Inténtalo de nuevo.");
            }
        }

        List<Process> procesos = new ArrayList<>();
        List<File> archivosSalida = new ArrayList<>();

        try {
            for (File archivoEntrada : new File(directorio).listFiles((dir, name) -> name.endsWith(".txt"))) {
                String archivoSalida = archivoEntrada.getAbsolutePath().replace(".txt", "_salida.txt");
                archivosSalida.add(new File(archivoSalida));

                ProcessBuilder pb = new ProcessBuilder("java", "procesos.ProcesoHijo",
                        archivoEntrada.getAbsolutePath(), archivoSalida);
                pb.directory(new File("bin"));
                pb.inheritIO();

                Process proceso = pb.start();
                procesos.add(proceso);
            }

            double sumaTotal = 0;
            boolean errorEnProcesos = false;

            for (int i = 0; i < procesos.size(); i++) {
                Process proceso = procesos.get(i);
                int codigoSalida = proceso.waitFor();

                if (codigoSalida != 0) {
                    System.out.println("El proceso hijo terminó con error. Código de salida: " + codigoSalida);
                    errorEnProcesos = true;
                    continue;
                }

                File archivoSalida = archivosSalida.get(i);
                if (!archivoSalida.exists()) {
                    System.err.println("Archivo de salida no encontrado: " + archivoSalida.getName());
                    errorEnProcesos = true;
                    continue;
                }

                try (BufferedReader reader = Files.newBufferedReader(archivoSalida.toPath())) {
                    String linea = reader.readLine();
                    if (linea != null && linea.startsWith("Total:")) {
                        sumaTotal += Double.parseDouble(linea.substring(7).trim());
                    }
                } catch (IOException | NumberFormatException e) {
                    System.err.println("Error al leer el archivo de salida: " + archivoSalida.getName());
                }
            }

            if (!errorEnProcesos) {
                System.out.println("Suma total de todos los archivos: " + sumaTotal);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la ejecución de procesos: " + e.getMessage());
        }
    }
}

package claseFile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej5 {
/*
 * Ejercicio 6.-
Hacer un programa que lea los valores del fichero de texto “numeros.txt” (0 al 9) y
cree el fichero “estadistica.txt”, donde se guarde las frecuencias, la moda (el
número que aparece con mayor frecuencia) y la media.
Ejemplo:
numeros.txt 4 5 2 1 6 2 1 1 3 5 5 9
estadistica.txt Número 0 – 0 veces
Número 1 – 3 veces
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "numeros.txt";
        String outputFile = "estadistica.txt";
        
        // Arreglo para contar las frecuencias de los números del 0 al 9
        int[] frecuencias = new int[10];
        int totalNumeros = 0;
        int sumaTotal = 0;
        
        // Leer los números del archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] numerosStr = linea.split("\\s+"); // Dividir la línea en números
                for (String numStr : numerosStr) {
                    try {
                        int numero = Integer.parseInt(numStr);
                        if (numero >= 0 && numero <= 9) { // Verificar que el número esté entre 0 y 9
                            frecuencias[numero]++;
                            sumaTotal += numero;
                            totalNumeros++;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Se encontró un valor no numérico: " + numStr);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero: " + e.getMessage());
            return;
        }
        
        // Calcular la(s) moda(s): números con mayor frecuencia
        int maxFrecuencia = Arrays.stream(frecuencias).max().orElse(0);
        List<Integer> modas = new ArrayList<>();
        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] == maxFrecuencia && maxFrecuencia > 0) {
                modas.add(i);
            }
        }
        
        // Calcular la media
        double media = totalNumeros > 0 ? (double) sumaTotal / totalNumeros : 0;
        
        // Guardar los resultados en el archivo de salida
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < frecuencias.length; i++) {
                pw.println("Número " + i + " – " + frecuencias[i] + (frecuencias[i] == 1 ? " vez" : " veces"));
            }
            pw.println("Moda: " + modas + " (aparece " + maxFrecuencia + (maxFrecuencia == 1 ? " vez)" : " veces)"));
            pw.printf("Media: %.2f\n", media);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero: " + e.getMessage());
        }
        
        System.out.println("Los resultados se han guardado en 'estadistica.txt'.");
	}

}

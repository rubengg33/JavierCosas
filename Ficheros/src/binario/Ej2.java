package binario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String outputFile = "personas.dat";
        Scanner scanner = new Scanner(System.in);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile))) {
            boolean continuar = true;
            
            while (continuar) {
                System.out.print("Introduce el nombre (20 caracteres max): ");
                String nombre = ajustarLongitud(scanner.nextLine(), 20);
                
                System.out.print("Introduce el primer apellido (20 caracteres max): ");
                String apellido1 = ajustarLongitud(scanner.nextLine(), 20);
                
                System.out.print("Introduce el segundo apellido (20 caracteres max): ");
                String apellido2 = ajustarLongitud(scanner.nextLine(), 20);
                
                System.out.print("Introduce el año de nacimiento: ");
                int anioNacimiento = Integer.parseInt(scanner.nextLine());

                // Escribir los datos en el archivo binario
                dos.writeUTF(nombre);
                dos.writeUTF(apellido1);
                dos.writeUTF(apellido2);
                dos.writeInt(anioNacimiento);

                // Preguntar si quiere añadir otra persona
                System.out.print("¿Quieres añadir otra persona? (s/n): ");
                continuar = scanner.nextLine().equalsIgnoreCase("s");
            }
            
            System.out.println("Archivo 'personas.dat' creado exitosamente.");
            
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    // Método para ajustar la longitud de la cadena a la longitud especificada
    private static String ajustarLongitud(String cadena, int longitud) {
        if (cadena.length() > longitud) {
            return cadena.substring(0, longitud); // Recorta si es demasiado largo
        } else {
            return String.format("%-" + longitud + "s", cadena); // Rellena con espacios si es más corto
        }
	}

}

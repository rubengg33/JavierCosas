package binario;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "personas.dat";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {
            System.out.println("Contenido del archivo 'personas.dat':");

            while (dis.available() > 0) {
                String nombre = dis.readUTF().trim();         // Leer nombre y eliminar espacios extras
                String apellido1 = dis.readUTF().trim();      // Leer primer apellido y eliminar espacios extras
                String apellido2 = dis.readUTF().trim();      // Leer segundo apellido y eliminar espacios extras
                int anioNacimiento = dis.readInt();           // Leer año de nacimiento

                System.out.printf("Nombre: %s, Apellido1: %s, Apellido2: %s, Año de nacimiento: %d%n",
                                  nombre, apellido1, apellido2, anioNacimiento);
            }
            
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
	}

}

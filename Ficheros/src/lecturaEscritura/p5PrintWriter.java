package lecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class p5PrintWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rutaArchivo ="C:\\dir1\\f1.txt";
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter wr = new PrintWriter(new FileWriter(rutaArchivo));
			System.out.println("Nombre: ");
			String nombre = sc.nextLine();
			System.out.println("Edad: ");
			int edad = sc.nextInt();
			System.out.println("Salario: ");
			double salario = sc.nextDouble();
			
			wr.println("Datos del usuario: ");
			wr.println("Nombre: " + nombre);
			wr.println("Edad: " + edad);
			wr.println("Salario: " + salario);
			
			wr.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

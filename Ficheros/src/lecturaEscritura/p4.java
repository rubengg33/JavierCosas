package lecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class p4 {

	public static void main(String[] args) {
		
		File archivo = new File("C:\\dir1\\f5.txt");
		Scanner sc = new Scanner(System.in);
		
		try {
			FileWriter escritor = new FileWriter(archivo, true);
			String linea;
			while (true) {
				System.out.print("Linea :");
				linea = sc.nextLine();
				if(linea.equalsIgnoreCase("fin")) {
					break;
				}
				escritor.write(linea+"\n");
			}
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

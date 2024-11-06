package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("C:\\dir1\\f1.txt");
		int caracter;
		try {
			FileReader fr = new FileReader(archivo);
			while((caracter = fr.read()) != -1) {
				System.err.print((char) caracter);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

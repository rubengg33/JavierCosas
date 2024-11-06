package lecturaEscritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class p7BufferedWritter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rutaArchivo ="C:\\dir1\\f1.txt";
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo,true));
			
			escritor.write("ola k ase\n");
			escritor.write("na de na\n");
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

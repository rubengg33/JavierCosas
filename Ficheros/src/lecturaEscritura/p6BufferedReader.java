package lecturaEscritura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p6BufferedReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rutaArchivo ="C:\\dir1\\f1.txt";
		try {
			BufferedReader lecturaBuffer = new BufferedReader
(new FileReader(rutaArchivo));
			String linea;
			while((linea = lecturaBuffer.readLine()) != null) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

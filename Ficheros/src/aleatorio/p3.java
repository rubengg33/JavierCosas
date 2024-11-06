package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class p3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String linea;
		String palabra;
		
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\dir1\\aleatorio1.txt","rw");
			System.out.println("Palabra: ");
			palabra = sc.nextLine();
			
			while((linea = raf.readLine()) != null) {
				raf.seek(raf.getFilePointer() - linea.length() -1);
				raf.writeBytes(cambiaLinea(linea, palabra) + "\n");	 
			}
			
					
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
static String cambiaLinea(String linea, String palabra) {
		StringBuilder auxSB = new StringBuilder(linea);
		int indice;
		indice  = auxSB.indexOf(palabra);
		while(indice != -1) {
			auxSB.replace(indice, indice + palabra.length(), palabra.toUpperCase());
			indice  = auxSB.indexOf(palabra);
		}
		return auxSB.toString();
	}

}

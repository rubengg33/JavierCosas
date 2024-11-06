package aleatorio;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class p1 {
static RandomAccessFile raf = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int entero;
		Scanner sc = new Scanner(System.in);
		try {
			raf = new RandomAccessFile("C:\\dir1\\enteros.dat","rw");
			verDatos();
			System.out.println("Entero: ");
			entero = sc.nextInt();
			raf.seek(raf.length());
			raf.writeInt(entero);
			verDatos();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
public static void verDatos() {
	int numeroEntero;
	try {
		raf.seek(0);
		while (true) {
			numeroEntero = raf.readInt();
			System.out.println(numeroEntero);
		}
	} catch (EOFException e) {
		// TODO: handle exception
		System.out.println("EOF");
	
	} catch (IOException e) {
		e.printStackTrace();
	}

}

	
}

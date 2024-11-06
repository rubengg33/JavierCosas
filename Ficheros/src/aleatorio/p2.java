package aleatorio;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tamanno;
		int posicion = 0;
		int entero = 0;
		Scanner sc = new Scanner(System.in);
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\dir1\\enteros.dat","rw");
			tamanno = raf.length()/4;
			System.out.println("Tamaño: "+ tamanno);
			do {
				System.out.println("Posicion a modificar: ");
				posicion = sc.nextInt();
			} while (posicion < 1 || posicion > tamanno);
			posicion--;
			
			raf.seek(posicion * 4);
			System.out.println("Valor actual: " +raf.readInt());
			System.out.println("Nuevo valor: ");
			entero = sc.nextInt();
			raf.seek(posicion *4);
			raf.writeInt(entero);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

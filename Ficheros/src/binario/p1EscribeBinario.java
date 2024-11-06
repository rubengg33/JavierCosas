package binario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class p1EscribeBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int codigoArticulo;
		double precio;
		
		try {
			FileOutputStream fos = new FileOutputStream("C:/dir1/articulo.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			System.out.println("Código artículo: ");
			codigoArticulo = sc.nextInt();
			
			while (codigoArticulo != 0) {
				dos.writeInt(codigoArticulo);
				System.out.println("Precio: ");
				precio = sc.nextDouble();
				dos.writeDouble(precio);
				System.out.println("Código artículo");
				codigoArticulo =sc.nextInt();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package lecturaEscritura;

import java.io.IOException;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int caracter=0;
		while (true) {
			try {
				caracter = System.in.read();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.err.println((char) caracter);
		}
	}

}

package procesos;

import java.io.IOException;

public class p3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String comando1 = "notepad.exe C:\\dir1\\aleatorio1.txt";
		ProcessBuilder pb1 = new ProcessBuilder(comando1);
		//pb1.start();
		String [] comando2 = {"notepad.exe","C:\\dir1\\aleatorio1.txt"};
		ProcessBuilder pb2 = new ProcessBuilder(comando2);
			//pb2.start();
			String comando3 = "notepad.exe C:\\dir1\\aleatorio1.txt";
			ProcessBuilder pb3 = new ProcessBuilder(comando3.split("\\s"));
			pb3.start(); 
	}
}

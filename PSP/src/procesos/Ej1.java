package procesos;

import java.io.IOException;
import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		int opcion;
		String opcion2;
		int tiempoent;
		Scanner sc = new Scanner(System.in);
		System.out.println("Que quieres hacer?");
		System.out.println("1. Apagar");
		System.out.println("2. Reiniciar");
		System.out.println("3. Hibernar");
		opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Quieres hacerlo inmediamamente o con tiempo?");
			System.out.println("Si es asi, pon s");
			opcion2= sc.next();
			if(opcion2.equalsIgnoreCase("s")) {
				if(esWindows) {
					System.out.println("Elige el tiempo en segundos: ");
					tiempoent = sc.nextInt();
					try {
						Runtime.getRuntime().exec(String.format("C:\\Windows\\System32\\shutdown -s -t "+ tiempoent));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Elige el tiempo en minutos: ");
					tiempoent = sc.nextInt();
					try {
						Runtime.getRuntime().exec(String.format("sudo shutdown +" +tiempoent));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
			
			else {//si no pone s, es decir lo quiere hacer inmediatamente
				if(esWindows) {
					try {
						Runtime.getRuntime().exec(String.format("C:\\Windows\\System32\\shutdown -s"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					try {
						Runtime.getRuntime().exec(String.format("sudo shutdown"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		break;
		
		case 2:
			if(esWindows) {
				try {
					Runtime.getRuntime().exec(String.format("C:\\Windows\\System32\\shutdown -r"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					Runtime.getRuntime().exec(String.format("sudo reboot"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		break;
	case 3:
		if(esWindows) {
			try {
				Runtime.getRuntime().exec(String.format("C:\\Windows\\System32\\shutdown -h"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				Runtime.getRuntime().exec(String.format("sudo hibernate"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		break;
		}
		
	}

}

package procesos;

import java.io.IOException;

public class p2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String directorioHome = System.getProperty("user.home");
		System.out.println(directorioHome);
		boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		System.out.println("OS NAME :"+System.getProperty("os.name")+ 
				" esWindows: " + esWindows);
		if(esWindows) {
			Runtime.getRuntime().exec(String.format("cmd.exe /c start cmd.exe /k dir %s", directorioHome));
		}
		else {
			Runtime.getRuntime().exec(String.format("sh -c ls %s", directorioHome));
		}
	}

}

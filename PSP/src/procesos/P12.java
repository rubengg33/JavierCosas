package procesos;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class P12 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("java","-version");
		pb.redirectErrorStream(true);
		
		File dir = new File("C:/dir1");
		File log = new File(dir, "java-version.log");
		
		pb.redirectOutput(Redirect.appendTo(log));
		Process p = pb.start();
		
		int salida = p.waitFor();
		System.out.println("Código salida: "+salida);
	}

}

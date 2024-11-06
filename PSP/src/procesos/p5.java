package procesos;

import java.io.File;
import java.io.IOException;

public class p5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String command = "java -jar install.jar -install";
		ProcessBuilder pbuilder = new ProcessBuilder(command.split("\\s"));
		pbuilder.directory(new File ("C:/dir1/JAR_Install"));
		boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		if(esWindows) {
			pbuilder.command().add(0,"cmd.exe");
			pbuilder.command().add(1,"start");
			pbuilder.command().add(2,"cmd.exe");
			pbuilder.command().add(3, "/k");
			pbuilder.command().add("C:\\dir1");
		}
		else {
			
		}
		System.out.println("Comando: " + pbuilder.command().toString());
		pbuilder.inheritIO();
		pbuilder.start();
	}

}

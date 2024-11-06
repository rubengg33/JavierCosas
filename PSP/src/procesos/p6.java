package procesos;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class p6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pbuilder = new ProcessBuilder();
//		pbuilder.environment()
		System.out.println("Directorio de Trabajo por defecto: "+System.getProperty("user.dir"));
		pbuilder.directory(new File(System.getProperty("user.home")));
		Map <String, String> environment = pbuilder.environment();
		String systemPath = environment.get("Path")+ "C:/dir1";
		environment.replace("Path",systemPath);
		System.out.println("Path: "+ environment.get("Path"));
		environment.put("Saludos","Hola a todos");
//		pbuilder.command().add("cmd.exe","start", "cmd.exe", "/k", "echo %Saludos%");
		pbuilder.command("cmd.exe","/c", "dir", "C:/dir2");
		pbuilder.redirectOutput(new File("C:/dir1/salida_proc.txt"));
		pbuilder.redirectError(new File("C:/dir1/salida_err.txt"));
//		pbuilder.inheritIO();
		pbuilder.start();
		Map variablesEntorno = pbuilder.environment();
		System.out.println("Variables de entorno: "+variablesEntorno);
		
		List command = pbuilder.command();
		Iterator it = command.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

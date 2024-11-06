package procesos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2 && args[0].equals("-install")) {
			String directorio = args[1];
			System.out.println("Instalando en el directorio : "+directorio);
			File dir = new File(directorio);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir,"instalacion.log");
			try {
				FileWriter fw  = new FileWriter(file);
				fw.write("Archivo de instalacion creado en: "+file.getAbsolutePath());
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Uso Incorrecto. Utilizar: -install <directorio>");
		}

	}

}

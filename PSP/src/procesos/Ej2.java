package procesos;

import java.io.File;

public class Ej2 {
/*
 * Programa que ejecute el comando ls o dir.
Modifica el valor de la propiedad user.dir. En la misma aplicación, cambiar el directorio de trabajo a la carpeta c:/temp o
/tmp, dependiendo del sistema operativo.
Muestra el valor devuelto por el método directory():
Después de crear la instancia de ProcessBuilder
Después de cambiar el valor de user.dir
Después de cambiar el directorio de trabajo al directorio temporal del sistema c:/temp o /tmp

 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		ProcessBuilder pbuilder = new ProcessBuilder();
		String tempDirWin = new String("c:/temp");
		String tempDirLin = new String("/tmp");
		if(esWindows) {
			System.out.println("Directorio actual (user.dir): " + System.getProperty("user.dir"));
			 System.setProperty("user.dir", tempDirWin);
			System.out.println("Directorio de Trabajo Cambiado: "+System.getProperty("user.dir"));
		}
		else {
			System.out.println("Directorio actual (user.dir): " + System.getProperty("user.dir"));
			System.setProperty("user.dir", tempDirLin);
			System.out.println("Directorio de Trabajo Cambiado: "+System.getProperty("user.dir"));
		}
		
	}

}

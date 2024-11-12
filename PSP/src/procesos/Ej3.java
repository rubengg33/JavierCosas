package procesos;

public class Ej3 {
	/*
	 * Realizar un programa que ejecute varios comandos (notepad, calc…) uno detrás
	 * de otro, de forma secuencial y haz que tu programa obtenga el código de
	 * finalización de cada uno de ellos. Para cada programa imprime el nombre y su
	 * código de finalización.
	 * 
	 * Prueba a poner aplicaciones que no existan o comandos con parámetros
	 * incorrectos.
	 * 
	 * ¿Qué hace el IDE si pones System.exit(10) al final del código para acabar tu
	 * programa?. Fíjate en la consola. ¿Qué hace el IDE si pones System.exit(0)
	 * para acabar tu programa?. ¿Cuál es entonces el valor por defecto?
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		if (esWindows) {
			Runtime.getRuntime().exec("calc"); 
			Runtime.getRuntime().exec("notepad");
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k dir C:\\Users\\user");
		}

	}
}

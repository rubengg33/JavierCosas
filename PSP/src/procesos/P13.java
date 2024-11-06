package procesos;

public class P13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("java","-version");
		ProcessHandle ph = ProcessHandle.current();
			ProcessHandle.Info processInfo = ph.info();
			System.out.println("PID: "+ ph.pid());
			System.out.println("Comando: "+ processInfo.command());
			System.out.println("Argumentos: "+ processInfo.arguments());
			System.out.println("Instante comienzo: "+ processInfo.startInstant());
			System.out.println("Tiempo total CPU: "+ processInfo.totalCpuDuration());
			System.out.println("Usuario :" +processInfo.user());
			
	}

}

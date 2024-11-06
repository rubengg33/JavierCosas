package procesos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class p7 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("notepad.exe");
		Process p = pb.start();
		boolean alive = p.isAlive();
//		System.out.println("alive: " + alive);
//		System.out.println("exitValue: " + p.exitValue());
		if(p.waitFor(10, TimeUnit.SECONDS)) {
			System.out.println("Proceso terminado");
		}
		else {
			System.out.println("Proceso No terminado");
		}
		p.destroy();
		System.out.println("exitValue: " + p.exitValue());
		alive = p.isAlive();
		System.out.println("alive: " + alive);
	}

}
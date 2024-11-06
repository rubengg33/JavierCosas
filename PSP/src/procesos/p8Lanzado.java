package procesos;

import java.io.IOException;

public class p8Lanzado {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		if(args.length!=1) {
			System.out.println("Uso: p8Lanzado <nombre_de_aplicacion>");
			System.exit(1);
		}
		
		String aplicacion = args[0];
		ProcessBuilder pb = new ProcessBuilder(aplicacion);
		Process proceso = pb.start();
		
		int codigoFinalizacion;
		try {
			codigoFinalizacion = proceso.waitFor();
			System.out.println("Código de finalizacion : " + codigoFinalizacion);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
	}

}

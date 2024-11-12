package threads;

public class P6_DosHilos {
	private static int numeroTarea = 0;
	private final int id = numeroTarea++;
	private int cuentaAtras = 10;
	
	public P6_DosHilos(int cuentaAtras) {
		this.cuentaAtras = cuentaAtras;
	}
	public String status() {
		return "#" + id + "(" + (cuentaAtras >0 ? cuentaAtras : "Despegue") +")";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P6_DosHilos lanzamiento1 = new P6_DosHilos(9);
		P6_DosHilos lanzamiento2 = new P6_DosHilos(7);
		
		Runnable runnable1 = () ->{
			while (lanzamiento1.cuentaAtras-- > 0) {
				System.out.println(lanzamiento1.status());
			}
		};
		Runnable runnable2 = () ->{
			while (lanzamiento2.cuentaAtras-- > 0) {
				System.out.println(lanzamiento2.status());
			}
		};
		
//		runnable1.run();
//		runnable2.run();
		new Thread(runnable1).start();
		new Thread(runnable2).start();
		System.out.println("Comienza la cuenta atras");
	}

}

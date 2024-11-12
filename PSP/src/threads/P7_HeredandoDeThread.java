package threads;

public class P7_HeredandoDeThread extends Thread{
	private static int numeroTarea = 0;
	private final int id = numeroTarea++;
	private int cuentaAtras = 10;
	public P7_HeredandoDeThread(int cuentaAtras) {
		this.cuentaAtras = cuentaAtras;
	}
	public String status() {
		return "#" + id + "(" + (cuentaAtras >0 ? cuentaAtras : "Despegue") +")";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread corriendo");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P7_HeredandoDeThread thread1 = new P7_HeredandoDeThread(9);
		thread1.start();
	}
	public void sumar() {
		cuentaAtras++;
	}
	
}

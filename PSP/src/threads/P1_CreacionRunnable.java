package threads;

public class P1_CreacionRunnable implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P1_CreacionRunnable miRunnable = new P1_CreacionRunnable();
		Thread thread = new Thread(miRunnable);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hilo corriendo");
	}

}

package threads;

public class P9_MetodosThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Main");
		System.out.println(Thread.currentThread().getName());

		ThreadGroup impares = new ThreadGroup("Threads Impares");
		ThreadGroup pares = new ThreadGroup("Threads Pares");
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new P9_MetodosThreadHilos();
			if(i%2 == 0) {
				new Thread(pares, runnable, "Thread" + i).start();
			}
			else {
				new Thread(impares, runnable, "Thread" + i).start();
			}
		}
		System.out.println("Hilo principal acabando");
	}

}

package threads;

public class P2_CreacionClaseaAnonima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable miRunnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hilo corriendo");
				
			}
		};
		
//		Thread thread = new Thread(miRunnable);
//		thread.start();
		new Thread(miRunnable).start();
	}

}

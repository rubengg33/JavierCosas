package threads;

public class P3_CreacionnExpresionLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable miRunnable = () -> {
			System.out.println("Thread corriendo");
		};
		
		Thread thread = new Thread(miRunnable);
		thread.start();
	}

}

package threads;

public class P8_ThreadClaseAnonima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread con clase anonima");
			}
		};
		
		thread.start();
	}

}

package threads;

public class P10_PrioridadMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P10_PrioridadHilo h1 = new P10_PrioridadHilo();
		P10_PrioridadHilo h2 = new P10_PrioridadHilo();
		P10_PrioridadHilo h3 = new P10_PrioridadHilo();
		h1.setPriority(5);
		h2.setPriority(10);
		h3.setPriority(1);
		h1.start();
		h2.start();
		h3.start();
		
		Thread.sleep(10000);
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		
		System.out.println("Prioridad maxima: " + h2.getContador());
		System.out.println("Prioridad normal: " + h1.getContador());
		System.out.println("Prioridad minima: " + h3.getContador());
	}

}

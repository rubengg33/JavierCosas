package threads;

public class P10_PrioridadHilo extends Thread{

		long c = 0;
		
		boolean stopHilo = false;
		
		public long getContador() {
			return c;
		}
		public void pararHilo() {
			stopHilo = true;
		}
		@Override
		public void run() {
		// TODO Auto-generated method stub
			while (!stopHilo) {
				c++;
			}
		}
		
}

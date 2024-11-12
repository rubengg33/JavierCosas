package threads;

public class P5_SinExpresionesLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacionSuma2 suma = new Suma();
		int resultado = suma.operar(5,4);
		System.out.println("Resultado: "+ resultado);
	}

}
interface OperacionSuma2{
	int operar(int a, int b);
}

class Suma implements OperacionSuma2{

	@Override
	public int operar(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
	
}
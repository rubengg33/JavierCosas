package threads;

public class P4_ExpresionesLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacionSuma suma = (a,b) -> a + b;
		int resultado = suma.operar(5, 4);
		System.out.println("Resultado: "+ resultado);
	}

}

interface OperacionSuma{
	int operar(int a, int b);
}
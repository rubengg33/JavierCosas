
public class Ejercicio3 {
	public static void main(String[] args) {
		System.out.println(Descuento(200.05));
	}
	public static String Descuento(double valor) {
		int porcentaje;
		if(valor>=150.10) {
			porcentaje=10;
			double descuento=valor*porcentaje/100;
			return "el porcentaje es: "+porcentaje+"%"+" y se descuenta "+descuento+"€";
			
		}
		else if(valor>200.05) {
		
			porcentaje=15;
			double descuento=valor*porcentaje/100;
			return "el porcentaje es: "+porcentaje+"%"+" y se descuenta "+descuento+"€";
			
		}
		return "No hay descuento";
		
	}

}

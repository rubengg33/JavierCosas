import java.util.Scanner;

public class Pruebas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pruebas programa = new Pruebas();
        
        // Pide al usuario el número antes de llamar a la función
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        String numero = sc.nextLine();
        
        String resultado = programa.Dias(numero);
        System.out.println("El día es: " + resultado);
    }

    public static String Dias(String numero){
        int diasemana = Integer.parseInt(numero);  // Conviertes a entero solo después de recibir el valor
        
        if(diasemana == 1) {
            return "Lunes";
        } else if(diasemana == 2) {
            return "Martes";
        } else if(diasemana == 3) {
            return "Miércoles";
        } else if(diasemana == 4) {
            return "Jueves";
        } else if(diasemana == 5) {
            return "Viernes";
        } else if(diasemana == 6) {
            return "Sábado";
        } else if(diasemana == 7) {
            return "Domingo";
        } else {
            return "Número inválido";
        }
    }
}

import java.util.Scanner;

public class PersonaMain {

	public static void main(String[] args) {
		Persona [] personasArray = new Persona[3];
		personasArray[0] =new Persona("Ana","Alvarez",22);
		personasArray[1] =new Persona("Pepe","Fernandez",22);
		personasArray[2] =new Persona("Elena","Sanchez",22);

		for (Persona personaItem : personasArray) {
			System.out.println(personaItem);
		}
		//System.out.println(menu());
		PersonaMain pm = new PersonaMain();
		System.out.println(pm.menu());
		
		
	}
	
	public int menu() {
		int opcion;
		Scanner sc= new Scanner(System.in);
		System.out.println("1.- Opcion1\n2. - Opcion2\n3. - Opcion3\n");
		opcion = sc.nextInt();
		return opcion;
	}

}

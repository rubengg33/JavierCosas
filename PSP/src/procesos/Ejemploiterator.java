package procesos;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejemploiterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Jose");
		lista.add("Jesus");
		lista.add("Diego");
		lista.add("Juan");
		lista.add("Sergio");
// el for each, no permite eliminar elementos
//		for (String nombre : lista) {
//			System.out.println(nombre);
//			if (nombre.equals("Diego")) {
//				lista.remove("Diego");
//			}
//		}
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			String nombre = it.next();
			System.out.println(nombre);
			if (nombre.equals("Diego")) {
				it.remove();
			}
		}
		System.out.println("--------------------");

		it = lista.iterator();
		while (it.hasNext()) {
			String nombre = it.next();
			System.out.println(nombre);

		}

	}

}

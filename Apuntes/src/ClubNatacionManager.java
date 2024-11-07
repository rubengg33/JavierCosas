
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubNatacionManager {

	// Lista de nadadores en el club
	private List<Nadador> nadadores;

	public ClubNatacionManager() {
		nadadores = new ArrayList<>();
	}

	public void agregarNadador(Nadador nadador) {
		nadadores.add(nadador);
	}

	public List<Nadador> obtenerNadadores() {
		return nadadores;
	}

	public Nadador obtenerNadadorPorNif(String nif) {
		for (Nadador nadador : nadadores) {
			if (nadador.getNif().equals(nif)) {
				return nadador;
			}
		}
		return null;
	}

	public void eliminarNadador(String nif) {
		Nadador nadador = obtenerNadadorPorNif(nif);
		if (nadador != null) {
			nadadores.remove(nadador);
		}
	}

	public void modificarNadador(String nif) {
		Nadador nadador = obtenerNadadorPorNif(nif);
		if (nadador != null) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Ingrese el nuevo nombre: ");
			nadador.setNombre(scanner.nextLine());

			System.out.println("Ingrese la nueva fecha de nacimiento (dd-mm-aaaa): ");
			nadador.setFechaNacimiento(scanner.nextLine());

			System.out.println("Ingrese el nuevo peso (kg): ");
			nadador.setPeso(scanner.nextDouble());

			System.out.println("Ingrese la nueva altura (cm): ");
			nadador.setAltura(scanner.nextInt());
			scanner.nextLine(); // Consumir el salto de línea

			System.out.println("Nadador modificado con éxito.");
		} else {
			System.out.println("Nadador no encontrado.");
		}
	}

	public void cargarDeArchivoTexto(String ruta) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ruta + "/nadadores.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String nombre = data[0];
				String nif = data[1];
				String fechaNacimiento = data[2];
				double peso = Double.parseDouble(data[3]);
				int altura = Integer.parseInt(data[4]);
				Nadador nadador = new Nadador(nombre, nif, fechaNacimiento, peso, altura);
				nadadores.add(nadador);
			}
		} catch (IOException e) {
			System.out.println("Error al cargar los datos: " + e.getMessage());
		}
	}

	public void guardarNadadoresAFicheroTexto(String ruta) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/nadadores.txt"));
			for (Nadador nadador : nadadores) {
				writer.write(nadador.toCsv());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al guardar los datos: " + e.getMessage());
		}
	}

	public void cargarNadadoresDeFicheroObjetos(String ruta) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta + "/nadadores.obj"));
			nadadores = (List<Nadador>) ois.readObject();
			System.out.println("Datos cargados desde archivo de objetos.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar desde archivo de objetos: " + e.getMessage());
		}
	}

	public void guardarNadadoresAFicheroObjetos(String ruta) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta + "/nadadores.obj"));
			oos.writeObject(nadadores);
			System.out.println("Datos guardados en archivo de objetos.");
		} catch (IOException e) {
			System.out.println("Error al guardar en archivo de objetos: " + e.getMessage());
		}
	}

	public void cargarNadadoresDeFicheroBinario(String ruta) {
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(ruta + "/nadadores.dat"));
			nadadores.clear();
			while (dis.available() > 0) {
				String nombre = dis.readUTF();
				String nif = dis.readUTF();
				String fechaNacimiento = dis.readUTF();
				double peso = dis.readDouble();
				int altura = dis.readInt();
				nadadores.add(new Nadador(nombre, nif, fechaNacimiento, peso, altura));
			}
			System.out.println("Datos cargados desde archivo binario.");
		} catch (IOException e) {
			System.out.println("Error al cargar desde archivo binario: " + e.getMessage());
		}
	}

	public void guardarNadadoresAFicheroBinario(String ruta) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta + "/nadadores.dat"));
			for (Nadador nadador : nadadores) {
				dos.writeUTF(nadador.getNombre());
				dos.writeUTF(nadador.getNif());
				dos.writeUTF(nadador.getFechaNacimiento());
				dos.writeDouble(nadador.getPeso());
				dos.writeInt(nadador.getAltura());
			}
			System.out.println("Datos guardados en archivo binario.");
		} catch (IOException e) {
			System.out.println("Error al guardar en archivo binario: " + e.getMessage());
		}
	}

	public void cargarNadadoresDeFicheroNIO(String ruta) {
		try {
			Path path = Paths.get(ruta + "/nadadores.nio");
			nadadores.clear();
			List<String> lines = Files.readAllLines(path);
			for (String line : lines) {
				String[] data = line.split(",");
				String nombre = data[0];
				String nif = data[1];
				String fechaNacimiento = data[2];
				double peso = Double.parseDouble(data[3]);
				int altura = Integer.parseInt(data[4]);
				nadadores.add(new Nadador(nombre, nif, fechaNacimiento, peso, altura));
			}
			System.out.println("Datos cargados desde archivo NIO.");
		} catch (IOException e) {
			System.out.println("Error al cargar desde archivo NIO: " + e.getMessage());
		}
	}

	public void guardarNadadoresAFicheroNIO(String ruta) {
		try {
			Path path = Paths.get(ruta + "/nadadores.nio");
			List<String> lines = new ArrayList<>();
			for (Nadador nadador : nadadores) {
				lines.add(nadador.toCsv());
			}
			Files.write(path, lines);
			System.out.println("Datos guardados en archivo NIO.");
		} catch (IOException e) {
			System.out.println("Error al guardar en archivo NIO: " + e.getMessage());
		}
	}
}

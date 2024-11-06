import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class AccesoDatos implements IAccesoDatos{
	File fichero = new File("peliculas.txt");
	public Boolean existe(Boolean existe) {
		if(fichero.exists()) {
			return true;
		}
		return false;
		
		
	}
	@Override
	public String listar(String pelicula) {
		
		return null;
	}
	@Override
	public void escribir(String pelicula, String nombreArchivo, Boolean anexar) {
		// TODO Auto-generated method stub
		   File fichero = new File(nombreArchivo);
		   try {
			PrintWriter salida = new PrintWriter(new FileWriter(fichero,anexar));
			salida.println(pelicula);
			if(anexar) {
				System.out.println("archivo" +nombreArchivo+"modificado exitosamente");
			}else {
				System.out.println("archivo" +nombreArchivo+"sobreescrito exitosamente");
			}
		} catch (IOException ex) {
			// TODO: handle exception
			System.out.println("Error: escritura fallida");
			}
			   System.out.println(nombreArchivo+"no existe.");
	}
	
	@Override
	public String buscar(String nombreArchivo, String busqueda) {
		
		try {
			File buscar = new File(nombreArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(busqueda));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado");
		}
		return "Encontrado";
	}
	@Override
	public void crear(String nombreArchivo) {
		
		try {
			File nuevo = new File(nombreArchivo);
			PrintWriter pw = new PrintWriter(nuevo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void borrar(String nombreArchivo) {
		// TODO Auto-generated method stub
		
	}
	
}

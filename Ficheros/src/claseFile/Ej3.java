package claseFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String rutaFichero = "texto.txt";
        
        try {
            // Leer el contenido original del fichero
            String contenido = new String(Files.readAllBytes(Paths.get(rutaFichero)));
            
            // Modificar el contenido insertando un * delante de cada vocal
            String contenidoModificado = contenido.replaceAll("([aeiouAEIOU])", "*$1");
            
            // Sobreescribir el fichero con el contenido modificado
            Files.write(Paths.get(rutaFichero), contenidoModificado.getBytes());
            
            // Mostrar el contenido modificado
            System.out.println("Contenido del fichero 'texto.txt' modificado:");
            System.out.println(contenidoModificado);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al acceder al fichero: " + e.getMessage());
        }
	}

}

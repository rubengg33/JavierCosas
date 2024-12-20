package nio;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
public class Ej1 {

   

    public static void main(String[] args) {
        Path archivoOrigen = Path.of("origen.txt"); // Cambia esto al archivo que desees copiar
        Path archivoDestino = Path.of("destino.txt"); // Cambia esto al archivo de destino

        // Verificar si el archivo de origen existe
        if (Files.notExists(archivoOrigen)) {
            System.out.println("El archivo de origen no existe: " + archivoOrigen);
            return;
        }

        // Copiar el archivo
        copiarArchivo(archivoOrigen, archivoDestino);
    }
    public static void copiarArchivo(Path origen, Path destino) {
        // Definir un buffer de 1024 bytes
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try (FileChannel channelOrigen = FileChannel.open(origen, StandardOpenOption.READ);
             FileChannel channelDestino = FileChannel.open(destino, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            // Leer del archivo de origen y escribir en el archivo de destino
            while (channelOrigen.read(buffer) > 0) {
                buffer.flip(); // Preparar el buffer para escribir en el destino
                channelDestino.write(buffer); // Escribir en el archivo de destino
                buffer.clear(); // Limpiar el buffer para la siguiente lectura
            }

            System.out.println("Archivo copiado exitosamente de " + origen + " a " + destino);
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}
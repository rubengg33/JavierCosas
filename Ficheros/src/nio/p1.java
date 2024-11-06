package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p1 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		operacionesNIO("eliminar");
//		leer();
//		escribir();
//		escribirPorChannel();
		leerPorChannel();
	}
	public static void operacionesNIO(String operacion) throws IOException {
		Path ruta = Paths.get("C:/dir1/nio1.txt");
		Path directorio = Paths.get("C:/dir1/NIO/NIO2");
		Path fich = Paths.get(directorio+"/ffff.txt");
		Path origen = Paths.get("C:/dir1/f1.txt");
		Path destino = Paths.get("C:/dir1/f1_copia.txt");
		switch (operacion) {
		case "existe":
			boolean existe = Files.exists(ruta, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
			System.out.println("Existe: "+ existe);
			break;
		case "crear":
			Path nuevoPath = Files.createDirectories(directorio);
			break;
		case "copiar":
			Files.copy(origen, destino);
			break;
		case "mover":
			Files.move(destino,fich,new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
			break;
		case "eliminar":
			Files.delete(fich);
		default:
			break;
		}
	}
	public static void leer() throws IOException {
		Path path = Paths.get("C:/dir1/f1.txt");
		byte [] bytes = Files.readAllBytes(path);
		for (byte b : bytes) {
			System.out.print((char) b);
		}
	}
	public static void escribir() throws IOException {
		Path path = Paths.get("C:/dir1/f1.txt");
		String texto = "pues feliz jaloguin";
		Files.write(path, texto.getBytes());
	}
	public static void escribirPorChannel() throws IOException {
		RandomAccessFile file = new RandomAccessFile("C:/dir1/f6.txt","rw");
		FileChannel channel = file.getChannel();
		String texto = "ola k ase";
		ByteBuffer buf = ByteBuffer.allocate(128);
		buf.clear();
		buf.put(texto.getBytes());
		buf.flip();
		while(buf.hasRemaining()) {
			channel.write(buf);
		}
		file.close();
	}
	public static void leerPorChannel() throws IOException {
		RandomAccessFile file = new RandomAccessFile("C:/dir1/f6.txt","rw");
		FileChannel channel = file.getChannel();
		long size = channel.size();
		ByteBuffer buf = ByteBuffer.allocate((int) size);
		int BytesRead = channel.read(buf);
		while(BytesRead != -1) {
			System.out.println("Leidos: "+BytesRead);
			buf.flip();
			while(buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			BytesRead = channel.read(buf);
		}
		file.close();
	}
}

package claseFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class EjercicioPropuesto implements FilenameFilter{
	private static char respuesta;
	private static int opcion;
	private static String padre;
	private static String hijo;
	private static String ruta;
	private static Scanner sc = new Scanner(System.in);

	/*
	 * borrar, listar, renombrar, si es elemento, que te diga la informacion, de si
	 * es ejecutable, esta oculto, etc.
	 */
	public static void main(String[] args)throws IOException {
		Menu();
		
	}
	public static void Menu() throws IOException {
		System.out.println("Elige una opción :");
		System.out.println(" 1 - Crear elemento");
		System.out.println(" 2 - Borrar elemento");
		System.out.println(" 3 - Listar");
		System.out.println(" 4 - Renombrar");
		System.out.println(" 5 - Información del archivo");
		System.out.println(" 6 - Salir");
		opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			Crear();
			break;
		case 2:
			Borrar();
			break;
		case 3:
			Listar(null, opcion);
			break;
		case 4:
			
			break;
		case 5:

			break;
		case 6:

			break;

		default:
			
			break;
		}
	}
	public static void Crear() throws IOException {
		System.out.println("Dime la ruta del archivo");
		padre = sc.next();
		File directorioPadre = new File(padre);
		System.out.println("Dime el nombre del elemento");
		hijo = sc.next();
		File elemento = new File(directorioPadre, hijo);
		if (directorioPadre.exists()) {
			System.out.println("Ruta: " + padre + "existe");
			if (elemento.exists()) {
				System.out.println("El elemento " + hijo + " Existe");
			} else {
				System.out.println("El elemento " + hijo + " No Existe");
				System.out.println("Quieres crearlo [S|N]");
				sc.nextLine();
				respuesta = sc.nextLine().toUpperCase().charAt(0);
				switch (respuesta) {
				case 'S':
					System.out.println("Fichero o Directorio[F|D]: ");
					respuesta = sc.nextLine().toUpperCase().charAt(0);
					switch (respuesta) {
					case 'F':
						if (elemento.createNewFile()) {
							System.out.println("Fichero: " + elemento.getAbsolutePath() + " Creado Correctamente");
						} else {
							System.out.println(
									"Fichero: " + elemento.getAbsolutePath() + " No se ha creado Correctamente");
						}
						break;
					case 'D':
						if (elemento.mkdirs()) {
							System.out
									.println("Directorio: " + elemento.getAbsolutePath() + " Creado Correctamente");
						} else {
							System.out.println(
									"Directorio: " + elemento.getAbsolutePath() + " No se ha creado Correctamente");
						}
						break;
					default:
						System.out.println("Has elegido una opción no válida");
						break;
					}
					break;
				case 'N':
					System.out.println("No se ha creado el elemento");
					break;
				default:
					System.out.println("Opcion no valida");
					break;
				}
			}
		} else {
			System.out.println("Ruta: " + padre + "No existe");
			System.out.println("Crearla? [S|N]");
			sc.nextLine();
			respuesta = sc.nextLine().toUpperCase().charAt(0);
			switch (respuesta) {
			case 'S':
				if (directorioPadre.mkdirs()) {
					System.out.println("Directorio" + directorioPadre.getAbsolutePath() + "creado exitosamente");
				} else {
					System.out.println(
							"Directorio" + directorioPadre.getAbsolutePath() + "No se ha creado exitosamente");
				}
				break;
			case 'N':
				System.out.println("No se ha creado el directorio");
				break;

			default:
				System.out.println("Opcion no válida");
				break;
			}
		}
	}
	public static void Borrar() {
		System.out.println("Borrar [F|D]");
		respuesta = sc.next().toUpperCase().charAt(0); // Leer la opción para borrar
		File elementoABorrar = new File(ruta); // Crea un objeto File con la ruta proporcionada

		switch (respuesta) {
		case 'F':
			elementoABorrar.renameTo(elementoABorrar);
			if (elementoABorrar.exists() && elementoABorrar.isFile()) {
				if (elementoABorrar.delete()) {
					System.out.println("Fichero " + elementoABorrar.getAbsolutePath() + " borrado correctamente");
				} else {
					System.out.println("No se pudo borrar el fichero " + elementoABorrar.getAbsolutePath());
				}
			} else {
				System.out.println("El fichero no existe o no es un fichero válido");
			}
			break;

		case 'D':
			if (elementoABorrar.exists() && elementoABorrar.isDirectory()) {
				if (elementoABorrar.delete()) {
					System.out.println("Directorio " + elementoABorrar.getAbsolutePath() + " borrado correctamente");
				} else {
					System.out.println("No se pudo borrar el directorio " + elementoABorrar.getAbsolutePath());
				}
			} else {
				System.out.println("El directorio no existe o no es un directorio válido");
			}
			break;  

		default:
			System.out.println("No es una opción válida");
			break;
		}
	}

	public static void Listar(File directorioPadre, int nivel) {
		// Obtener todos los archivos y subdirectorios del directorio actualç
		System.out.println("Dime la ruta que quieres listar");
		padre = sc.next();
		File dir = new File(padre);
		File[] contenido = dir.listFiles();
		for (File fich : contenido) {
			System.out.println("Elemento "+ fich.toString());
			
			
		}
		
		System.out.println("----------------------");
		
		EjercicioPropuesto objetoListar = new EjercicioPropuesto();
		contenido = dir.listFiles(objetoListar);
		for (File fich : contenido) {
			System.out.println("Elemento "+ fich.toString());
			
			
		}
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return false;
	}
}
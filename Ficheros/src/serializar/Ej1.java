package serializar;

import java.util.Scanner;

public class Ej1 {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Agenda agenda = new Agenda();
	        boolean salir = false;

	        while (!salir) {
	            System.out.println("Menú:");
	            System.out.println("A. Dar de alta un nuevo contacto");
	            System.out.println("B. Buscar contacto");
	            System.out.println("C. Modificar contacto");
	            System.out.println("D. Eliminar contacto");
	            System.out.println("E. Mostrar todos los contactos");
	            System.out.println("F. Salir");
	            System.out.print("Elige una opción: ");
	            String opcion = scanner.nextLine().toUpperCase();

	            switch (opcion) {
	                case "A":
	                    System.out.print("Nombre: ");
	                    String nombre = scanner.nextLine();
	                    System.out.print("Apellidos: ");
	                    String apellidos = scanner.nextLine();
	                    System.out.print("Teléfono: ");
	                    String telefono = scanner.nextLine();
	                    System.out.print("Correo Electrónico: ");
	                    String correo = scanner.nextLine();
	                    agenda.agregarContacto(new Contacto(nombre, apellidos, telefono, correo));
	                    break;

	                case "B":
	                    System.out.print("Nombre: ");
	                    String nombreBuscar = scanner.nextLine();
	                    System.out.print("Apellidos: ");
	                    String apellidosBuscar = scanner.nextLine();
	                    Contacto contactoEncontrado = agenda.buscarContacto(nombreBuscar, apellidosBuscar);
	                    if (contactoEncontrado != null) {
	                        System.out.println("Contacto encontrado: " + contactoEncontrado);
	                    } else {
	                        System.out.println("Contacto no encontrado.");
	                    }
	                    break;

	                case "C":
	                    System.out.print("Nombre: ");
	                    String nombreModificar = scanner.nextLine();
	                    System.out.print("Apellidos: ");
	                    String apellidosModificar = scanner.nextLine();
	                    System.out.print("Nuevo Teléfono (dejar vacío para no modificar): ");
	                    String nuevoTelefono = scanner.nextLine();
	                    System.out.print("Nuevo Correo Electrónico (dejar vacío para no modificar): ");
	                    String nuevoCorreo = scanner.nextLine();
	                    agenda.modificarContacto(nombreModificar, apellidosModificar, 
	                                              nuevoTelefono.isEmpty() ? null : nuevoTelefono, 
	                                              nuevoCorreo.isEmpty() ? null : nuevoCorreo);
	                    break;

	                case "D":
	                    System.out.print("Nombre: ");
	                    String nombreEliminar = scanner.nextLine();
	                    System.out.print("Apellidos: ");
	                    String apellidosEliminar = scanner.nextLine();
	                    agenda.eliminarContacto(nombreEliminar, apellidosEliminar);
	                    break;

	                case "E":
	                    agenda.mostrarContactos();
	                    break;

	                case "F":
	                    salir = true;
	                    break;

	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	        scanner.close();
	    }
	}

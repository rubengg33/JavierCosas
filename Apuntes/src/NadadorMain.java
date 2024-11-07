import java.util.Scanner;

public class NadadorMain {

   public static void main(String[] args) {
        ClubNatacionManager manager = new ClubNatacionManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al gestor de club de natación.");

        String directorio;
        System.out.println("Ruta absoluta del directorio: ");
        directorio = scanner.nextLine();

        // Preguntar al usuario de dónde cargar los datos
        System.out.println("Seleccione de dónde cargar los datos:");
        System.out.println("1. Cargar desde archivo de texto (nadadores.txt)");
        System.out.println("2. Cargar desde archivo de objetos (nadadores.obj)");
        System.out.println("3. Cargar desde archivo binario (nadadores.dat)");
        System.out.println("4. Cargar desde archivo NIO (nadadores.nio)");
        System.out.println("5. Salir");
        System.out.print("Elija una opción (1/2/3/4/5): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                cargarNadadoresDeFicheroTexto(directorio);
                break;
            case 2:
                cargarNadadoresDeFicheroObjetos(directorio);
                break;
            case 3:
                cargarNadadoresDeFicheroBinario(directorio);
                break;
            case 4:
                cargarNadadoresDeFicheroNIO(directorio);
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opción no válida. Saliendo del programa.");
                scanner.close();
                System.exit(1);
        }

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar nadador");
            System.out.println("2. Ver nadadores");
            System.out.println("3. Modificar nadador");
            System.out.println("4. Guardar datos en archivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1/2/3/4/5): ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("NIF: ");
                    String nif = scanner.nextLine();
                    System.out.println("Fecha de nacimiento (dd-mm-aaaa): ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.println("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.println("Altura (cm): ");
                    int altura = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Nadador nuevoNadador = new Nadador(nombre, nif, fechaNacimiento, peso, altura);
                    nadadores.add(nuevoNadador);
                    System.out.println("Nadador agregado con éxito.");
                    break;
                case 2:
                    System.out.println("Lista de nadadores:");
                    for (Nadador nadador : nadadores) {
                        System.out.println(nadador);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el NIF del nadador que desea modificar: ");
                    String nifModificar = scanner.nextLine();
                    modificarNadador(nifModificar);
                    break;
                case 4:
                    System.out.println("Ruta absoluta del directorio: ");
                    directorio = scanner.nextLine();
                    // Preguntar al usuario dónde guardar los datos
                    System.out.println("Seleccione dónde guardar los datos:");
                    System.out.println("1. Guardar en archivo de texto (nadadores.txt)");
                    System.out.println("2. Guardar en archivo de objetos (nadadores.obj)");
                    System.out.println("3. Guardar en archivo binario (nadadores.dat)");
                    System.out.println("4. Guardar en archivo con NIO (nadadores.nio)");
                    System.out.println("5. Salir");
                    System.out.print("Elija una opción (1/2/3/4/5): ");
                    int opcionGuardar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionGuardar) {
                        case 1:
                            guardarNadadoresAFicheroTexto(directorio);
                            break;
                        case 2:
                            guardarNadadoresAFicheroObjetos(directorio);
                            break;
                        case 3:
                            guardarNadadoresAFicheroBinario(directorio);
                            break;
                        case 4:
                            guardarNadadoresAFicheroNIO(directorio);
                            break;
                        case 5:
                            System.out.println("Saliendo del programa.");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Opción no válida.");
                    }
                    System.out.println("Datos guardados en archivo.");
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}



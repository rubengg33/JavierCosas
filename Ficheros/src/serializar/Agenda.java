package serializar;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private static final String NOMBRE_ARCHIVO = "agenda.dat";
    private static final String NOMBRE_ELIMINADOS = "Eliminados.txt";
    private List<Contacto> contactos;

    public Agenda() {
        contactos = cargarAgenda();
    }

    private List<Contacto> cargarAgenda() {
        List<Contacto> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            while (true) {
                Contacto contacto = (Contacto) ois.readObject();
                lista.add(contacto);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la agenda: " + e.getMessage());
        }
        return lista;
    }

    public void guardarAgenda() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            for (Contacto contacto : contactos) {
                oos.writeObject(contacto);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda: " + e.getMessage());
        }
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        guardarAgenda();
    }

    public Contacto buscarContacto(String nombre, String apellidos) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                return contacto;
            }
        }
        return null;
    }

    public void modificarContacto(String nombre, String apellidos, String nuevoTelefono, String nuevoCorreo) {
        Contacto contacto = buscarContacto(nombre, apellidos);
        if (contacto != null) {
            if (nuevoTelefono != null) {
                contacto.setTelefono(nuevoTelefono);
            }
            if (nuevoCorreo != null) {
                contacto.setCorreoElectronico(nuevoCorreo);
            }
            guardarAgenda();
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void eliminarContacto(String nombre, String apellidos) {
        Contacto contacto = buscarContacto(nombre, apellidos);
        if (contacto != null) {
            contactos.remove(contacto);
            guardarAgenda();
            registrarEliminado(contacto);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private void registrarEliminado(Contacto contacto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ELIMINADOS, true))) {
            bw.write(contacto.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al registrar el contacto eliminado: " + e.getMessage());
        }
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }
}
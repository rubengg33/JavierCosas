import java.util.ArrayList;

public interface IPersona {
	public void eliminarPersona(Persona persona);
	public Persona actualizarPersona(Persona persona);
	public ArrayList<Persona> listaPersonas();
	public void agregarPersona(Persona persona);	
}

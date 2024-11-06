
public interface IAccesoDatos {
 public Boolean existe(Boolean existe);
 public String listar(String pelicula);
 public void escribir(String pelicula, String nombreArchivo, Boolean anexar);
 public String buscar(String nombreArchivo, String busqueda);
 public void crear(String nombreArchivo);
 public void borrar(String nombreArchivo);
}

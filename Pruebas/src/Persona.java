
public class Persona {

	private String apellido;
	private int edad;
	private double altura;
	private String identificación;
	private TipoId tipoId;
	private String correo;
	private String direccion;
	private String nacionalidad;
	private String genero;
	
	 public enum TipoId {
	        DNI,
	        NIE,
	        PASAPORTE
	    }

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getIdentificación() {
		return identificación;
	}
	public void setIdentificación(String identificación) {
		this.identificación = identificación;
	}
	public TipoId getTipoId() {
		return tipoId;
	}
	public void setTipoId(TipoId tipoId) {
		this.tipoId = tipoId;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	private String nombre;
	public Persona(String nombre, String apellido, int edad, double altura, String identificación, TipoId tipoId,
			String correo, String direccion, String nacionalidad, String genero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.altura = altura;
		this.identificación = identificación;
		this.tipoId = tipoId;
		this.correo = correo;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", edad=" + edad + ", altura=" + altura + ", identificación="
				+ identificación + ", tipoId=" + tipoId + ", correo=" + correo + ", direccion=" + direccion
				+ ", nacionalidad=" + nacionalidad + ", genero=" + genero + ", nombre=" + nombre + "]";
	}
	public Persona() {
		super();
	}
	
}

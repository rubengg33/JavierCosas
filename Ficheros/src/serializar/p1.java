package serializar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class p1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("Eduardo", 40000, 2012, 3, 1, 3000);
		Empleado [] personal = new Empleado[3];
		personal[0] = jefe;
		personal[1] = new Empleado("Alvaro",20000,2022,4,6);
		personal[2] = new Empleado("Estefania",30000,2021,6,7);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/dir1/personal.dat"));
		oos.writeObject(personal);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/dir1/personal.dat"));
		 Empleado [] personalRecuperado = (Empleado[]) ois.readObject();
		 for (Empleado e : personalRecuperado) {
			System.out.println(e);
		}
	}
	
}
class Empleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
	public Empleado(String nombre, double sueldo, int anno, int mes, int dia) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anno, mes -1, dia);
		fechaContrato = calendario.getTime();
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", fechaContrato=" + fechaContrato + "]";
	}
	
}
class Administrador extends Empleado{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double incentivo;

	public Administrador(String nombre, double sueldo, int anno, int mes, int dia, double incentivo) {
		super(nombre, sueldo, anno, mes, dia);
		this.incentivo = incentivo;
	}

	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return "Administrador [incentivo=" + incentivo + ", getNombre()=" + getNombre() + ", getSueldo()="
				+ getSueldo() + ", getFechaContrato()=" + getFechaContrato() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	
}

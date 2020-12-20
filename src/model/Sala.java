package model;
/**
 * Clase sala
 * @author alex
 *
 */
public class Sala {

	protected String nombre;

	protected int numAsientos;

	public Sala(String nombre, int numAsientos) {
		super();
		this.nombre = nombre;
		this.numAsientos = numAsientos;
	}
	public Sala() {
		super();
		this.nombre = "";
		this.numAsientos = 0;
	}
	public Sala(Sala s) {
		super();
		this.nombre = s.nombre;
		this.numAsientos = s.numAsientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}



}

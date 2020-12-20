package model;
/**
 * Clase Sesion
 * @author alex
 *
 */
public class Sesion {

	private double hora;

	public Sesion(double hora) {
		super();
		this.hora = hora;
	}
	public Sesion() {
		this.hora=18.00;
	}

	public Sesion(Sesion s) {
		
		this.hora= s.hora;
		
	}
	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {

		if(hora==16.00||hora==18.00||hora==20.00||hora==22.00) {
			this.hora = hora;
		}else {
			System.out.println("Selecciona un horario disponible");
		}
	}



}

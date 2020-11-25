package model;


/**
 * CLase Administrador que hereda de Usuario
 * @author alex
 *
 */
public class Administrador extends Usuario {

	private boolean esAdmin;

	public Administrador(String username, String password, boolean esAdmin) {
		super(username, password);
		this.esAdmin = esAdmin;
	}

	public Administrador() {
		super();
		this.esAdmin = false;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}



}

/**
 * Clase Usuario Clase Padre de Cliente y Admin
 * @author alex
 *
 */
abstract class Usuario {
	
	private String username;
	private String password;
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Usuario() {
		super();
		this.username = "";
		this.password = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}

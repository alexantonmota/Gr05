/**
 * Clase Cliente que hereda de Usuario
 * @author alex
 *
 */
public class Cliente extends Usuario {
	
	private String email;
	private String nombre;
	private String apellido_1;
	private String apellido_2;
	private String fecha_nac;
	
	public Cliente(String username, String password, String email, String nombre, String apellido_1, String apellido_2,
			String fecha_nac) {
		super(username, password);
		this.email = email;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.fecha_nac = fecha_nac;
	}

	public Cliente() {
		super();
		this.email = "";
		this.nombre = "";
		this.apellido_1 = "";
		this.apellido_2 = "";
		this.fecha_nac = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	

}
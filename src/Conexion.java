import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	
private Connection conn = null;
	
	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:database/Usuario.db");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			e.printStackTrace();
		}
		return conn;
	}
}

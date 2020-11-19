import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	
private Connection conn = null;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto","root","boobooga70");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			e.printStackTrace();
		}
		return conn;
	}
}

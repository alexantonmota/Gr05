package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Clase Conexion que conecta con la base de datos
 * @author alex
 *
 */
public class Conexion {


	

	public static Connection conectar() {
		 Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto","root","boobooga70");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			e.printStackTrace();
		}
		return conn;
	}
	public static  ResultSet getTabla(String Consulta) {
		Connection conn= conectar();
		Statement stmt;
		ResultSet datos= null;
		try {	
			stmt= conn.createStatement();
			datos= stmt.executeQuery(Consulta);
			
			
		} catch (Exception e) {
			System.out.println("Error en obtener tabla");
		}
		return datos;
		
	}
}

package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import VistaCliente.CambiarImagen;
import VistaCliente.InicioSesion;
import VistaCliente.Registro;
import model.Cliente;
import model.Pelicula;

/**
 * Clase Conexion que conecta con la base de datos
 * @author alex
 *
 */
public class DBManager {

	private Connection conn;
	public DBManager () {
		conectar();
	}

	private void  conectar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto","root","boobooga70");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			e.printStackTrace();
		}

	}
	public void desconectar() {

		try {
			conn.close();


		}catch(Exception e){

			e.printStackTrace();
		}
	}

	public List<Pelicula> obtenerPeliculas() {

		String sql = "SELECT titulo, anyo, genero, sinopsis, duracion, trailer, nomPoster,nomPMenu,sala FROM pelicula";
		PreparedStatement stmt;

		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.clear();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Pelicula p = new Pelicula(rs.getString("titulo"), rs.getString("genero"), rs.getInt("anyo"), rs.getString("sinopsis"), rs.getInt("duracion"), rs.getString("trailer"), rs.getString("nomPoster"),rs.getString("nomPMenu"),rs.getInt("sala"));

				peliculas.add(p);
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}
		return peliculas;
	}
	public Cliente obtenerusuario(Cliente cli) {

		Cliente cliente= null;
		String sql = "select * from usuario where Username = ? and contr = ?";

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {


			pst = conn.prepareStatement(sql);
			pst.setString(1, cli.getUsername());
			pst.setString(2, cli.getPassword());
			rs = pst.executeQuery();

			while(rs.next()) {
				cliente = new Cliente(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}

		}catch (Exception e) {
			System.out.println("error en obtener usuario");
		}

		// TODO Auto-generated method stub
		return cliente;
	}
	public void login() {
		InicioSesion login= new InicioSesion();




		Cliente cl2 = new Cliente();
		cl2.setUsername(login.textField.getText());
		cl2.setPassword(String.valueOf(login.passwordField.getPassword()));



		Cliente usu =obtenerusuario(cl2);

		if(usu!=null) {
			login.frame.dispose();
			JOptionPane.showMessageDialog(login.frame, "BIENVENIDO");

			CambiarImagen cam= new CambiarImagen();
			CambiarImagen.main();

			InicioSesion.log.log(Level.FINER,"Usuario conectado: " + login.textField.getText());

		}else{
			JOptionPane.showMessageDialog(login.frame, "Datos no validos", "error", JOptionPane.ERROR_MESSAGE);
		}

	}
	public void registrar() {
		Registro rg= new Registro();
		String sql = "INSERT INTO Usuario (Username, contr, nombre, apellido1, apellido2, Fechanac, email) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, rg.txtUser.getText());
			pst.setString(2, String.valueOf(rg.passContr.getPassword()));
			pst.setString(3, rg.txtNombre.getText());
			pst.setString(4, rg.txtApe1.getText());
			pst.setString(5, rg.txtApe2.getText());
			pst.setString(6, rg.txtFecha.getText());
			pst.setString(7, rg.txtEmail.getText());
			int n = pst.executeUpdate();
			if(n>0) {
				JOptionPane.showMessageDialog(null, "Usuario registrado");
				InicioSesion.log.log(Level.FINER,"Usuario registrado: "+rg.txtNombre.getText());
				rg.clientes.put(rg.txtUser.getText(),String.valueOf(rg.passContr.getPassword()));
				rg.frame1.dispose();
				new InicioSesion();
			}
		}catch (SQLException l) {
			l.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los datos no son validos" +l.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}	

}





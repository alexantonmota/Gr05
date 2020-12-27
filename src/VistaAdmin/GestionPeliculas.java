package VistaAdmin;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;
import model.Genero;
import Conexion.Conexion;

public class GestionPeliculas {

	public List<Pelicula> obtenerPeliculas(){
		String sql = "SELECT titulo, genero, anyo, sinopsis, duracion, trailer, nomPoster,nomPMenu FROM prelicula";
		PreparedStatement stmt;
		Conexion cc= new Conexion();
		Connection conn= cc.conectar();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Pelicula p = new Pelicula(rs.getString("titulo"), rs.getString("genero"), rs.getInt("anyo"), rs.getString("sinopsis"), rs.getInt("duracion"), rs.getString("trailer"), rs.getString("nomPoster"),rs.getString("nomPMenu"));

				peliculas.add(p);
			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return peliculas;
	}
}

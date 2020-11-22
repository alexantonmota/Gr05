import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GestionPeliculas {

	public Pelicula obtenerpeliculas(Pelicula peli) {
		Pelicula pelis = null;

		Conexion conexion2 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from pelicula";
			pst = cn2.prepareStatement(sql);

			pst.setString(1, peli.getTitulo());
			rs = pst.executeQuery();

			while(rs.next()) {
				pelis = new Pelicula(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7),rs.getString(8));
			}

		}catch (Exception e) {
			System.out.println("error en obtener Pelicula");
		}
		return pelis;
	}
}

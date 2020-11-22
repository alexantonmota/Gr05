import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GestionClientes2 {

	public Cliente obtenerusuario2(Cliente cli1) {
		Cliente cl1 = null;

		Conexion conexion2 = new Conexion();
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;

		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from usuario where username = ?";
			pst1 = cn2.prepareStatement(sql);
			pst1.setString(1, cli1.getUsername());
			rs1 = pst1.executeQuery();

			while(rs1.next()) {
				cl1 = new Cliente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7));
			}

		}catch (Exception e) {
			System.out.println("Error en obtener usuario");
		}
		return cl1;
	}
}

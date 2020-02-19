package conexion;

import java.sql.*;

public class Conexion {
	public static Connection conectar() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://127.0.0.1:3306/supermercado?user=root";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion OK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

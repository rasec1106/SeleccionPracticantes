package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.IGestorPermisos;
import util.MySQLConnection;

public class GestorPermisos implements IGestorPermisos{

	@Override
	public boolean obtenerPermisoMenu(int idMenu, int idUserType) {
		boolean permitido = false;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Permission_Menu WHERE idUserType = ? AND idMenu = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, idUserType);
			stm.setInt(2, idMenu);
			rs = stm.executeQuery();
			while (rs.next()) {
				permitido=true;
			}
		}catch (Exception e) {
			System.out.println("Error en BD : " + e.getMessage());
		} finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally : " + e2.getMessage());
			}
		}		
		return permitido;
	}

}

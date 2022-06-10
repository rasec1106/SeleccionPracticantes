package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorArea;
import model.Area;
import util.MySQLConnection;

public class GestorArea implements IGestorArea {

	@Override
	public ArrayList<Area> listar() {
		ArrayList<Area> lista = new ArrayList<Area>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Area";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Area obj = new Area();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public Area obtener(int id) {
		Area obj = new Area();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Area WHERE id = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
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
		
		return obj;
	}

}

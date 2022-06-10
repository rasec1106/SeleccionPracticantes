package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorConvocatoria;
import model.Convocatoria;
import util.MySQLConnection;

public class GestorConvocatoria implements IGestorConvocatoria {
	private GestorArea gestorArea = new GestorArea();

	@Override
	public ArrayList<Convocatoria> listar() {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Convocatoria obj = new Convocatoria();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setDescription(rs.getString("Description"));
				obj.setStartDate(rs.getString("startDate"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setPosition(rs.getString("position"));
				obj.setArea(gestorArea.obtener(rs.getInt("idArea")) );
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

}

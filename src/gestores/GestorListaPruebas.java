package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorListaPruebas;
import model.ListaPruebas;
import util.MySQLConnection;

public class GestorListaPruebas implements IGestorListaPruebas {

	@Override
	public ArrayList<ListaPruebas> listar() {
		ArrayList<ListaPruebas> lista = new ArrayList<ListaPruebas>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT ts.id ID, ts.name Nombre, tp.name Convocatoria FROM tb_Test ts LEFT JOIN tb_Proposal tp ON tp.id = ts.idProposal";
			stm = cn.prepareStatement(sql);
			//stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				ListaPruebas obj = new ListaPruebas();
				obj.setId(rs.getInt("ID"));
				obj.setName(rs.getString("Nombre"));
				obj.setNameProposal(rs.getString("Convocatoria"));
				lista.add(obj);
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
		return lista;
	}

	@Override
	public ArrayList<ListaPruebas> buscarXID(String filtro) {
		ArrayList<ListaPruebas> lista = new ArrayList<ListaPruebas>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
		 	cn = MySQLConnection.getConnection();
		 	String sql = "SELECT ts.id ID, ts.name Nombre, tp.name Convocatoria FROM tb_Test ts LEFT JOIN tb_Proposal tp ON tp.id = ts.idProposal WHERE ts.id LIKE ?";
		 	stm = cn.prepareStatement(sql);
		 	stm.setString(1, "%" + filtro + "%");
		 	rs = stm.executeQuery();
		 	while (rs.next()) {
		 		ListaPruebas obj = new ListaPruebas();
				obj.setId(rs.getInt("ID"));
				obj.setName(rs.getString("Nombre"));
				obj.setNameProposal(rs.getString("Convocatoria"));
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
	public ArrayList<ListaPruebas> buscarXNombre(String filtro) {
		ArrayList<ListaPruebas> lista = new ArrayList<ListaPruebas>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
		 	cn = MySQLConnection.getConnection();
		 	String sql = "SELECT ts.id ID, ts.name Nombre, tp.name Convocatoria FROM tb_Test ts LEFT JOIN tb_Proposal tp ON tp.id = ts.idProposal WHERE ts.name LIKE ? OR tp.name LIKE ?";
		 	stm = cn.prepareStatement(sql);
		 	stm.setString(1, "%" + filtro + "%");
		 	stm.setString(2, "%" + filtro + "%");
		 	rs = stm.executeQuery();
		 	while (rs.next()) {
		 		ListaPruebas obj = new ListaPruebas();
				obj.setId(rs.getInt("ID"));
				obj.setName(rs.getString("Nombre"));
				obj.setNameProposal(rs.getString("Convocatoria"));
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

package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorPrueba;
import model.Convocatoria;
import model.Prueba;
import util.MySQLConnection;

public class GestorPrueba implements IGestorPrueba {

	private GestorPregunta gestor = new GestorPregunta();
	@Override
	public Prueba obtener(int id) {
		Prueba obj = new Prueba();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Test WHERE id = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setQuestions(gestor.listarPreguntasXConvocatoria(id));
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
	@Override
	public ArrayList<Prueba> listarxConvocatoria(int filtro) {
		ArrayList<Prueba> lista = new ArrayList<Prueba>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Test t JOIN tb_Proposal p ON t.idProposal = p.id WHERE p.name LIKE ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, filtro);
			rs = stm.executeQuery();
			while (rs.next()) {
				Prueba obj = new Prueba();
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



}

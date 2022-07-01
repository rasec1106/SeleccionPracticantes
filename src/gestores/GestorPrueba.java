package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorPrueba;
import model.Candidato;
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
			String sql = "SELECT * FROM tb_Test WHERE idProposal =  ?";
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
	@Override
	public int registrar(Prueba prueba, Convocatoria convocatoria) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO tb_Test(name, idProposal) VALUES (?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1,prueba.getName());
			stm.setInt(2,convocatoria.getId());
			resultado = stm.executeUpdate();
			resultado = registrarPreguntas(prueba);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return resultado;
	}
	
	private int registrarPreguntas(Prueba prueba) {
		int resultado = -1;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT id FROM tb_Test ORDER BY id DESC LIMIT 1";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {				
				int idTest = rs.getInt("id");
				resultado = new GestorPregunta().registrarPreguntas(prueba.getQuestions(), idTest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return resultado;
	}
	@Override
	public int calificar(Prueba prueba, Candidato candidato) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO tb_Test_Candidate VALUES (?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1, candidato.getDni());
			stm.setInt(2,prueba.getId());
			stm.setInt(3,prueba.getMark());
			resultado = stm.executeUpdate();
			resultado = registrarPreguntas(prueba);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return resultado;
	}



}

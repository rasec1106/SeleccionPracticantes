package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorCandidato;
import model.Candidato;
import util.MySQLConnection;

public class GestorCandidato implements IGestorCandidato {

	@Override
	public ArrayList<Candidato> listar() {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Candidate";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Candidato obj = new Candidato();
				obj.setDni(rs.getString("dni"));
				obj.setName(rs.getString("name"));
				obj.setSurname(rs.getString("surname"));
				obj.setEmail(rs.getString("email"));
				obj.setBirthDate(rs.getString("birthDate"));
				obj.setCurriculum(rs.getString("curriculum"));
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
	public int registrar(Candidato obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO tb_Candidate VALUES (?,?,?,?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1,obj.getDni());
			stm.setString(2,obj.getName());
			stm.setString(3,obj.getSurname());
			stm.setString(4,obj.getEmail());
			stm.setString(5,obj.getBirthDate());
			stm.setString(6,obj.getCurriculum());
			resultado = stm.executeUpdate();
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
	public int actualizar(Candidato obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE tb_Candidate SET name = ?, surname = ?, email = ?, birthDate = ?, curriculum = ? "
					+ "WHERE dni = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1,obj.getName());
			stm.setString(2,obj.getSurname());
			stm.setString(3,obj.getEmail());
			stm.setString(4,obj.getBirthDate());
			stm.setString(5,obj.getCurriculum());
			stm.setString(6,obj.getDni());
			resultado = stm.executeUpdate();
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
	public int eliminar(String dni) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "DELETE FROM tb_Candidate WHERE dni = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, dni);
			resultado = stm.executeUpdate();
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
	public Candidato obtener(String dni) {
		Candidato obj = new Candidato();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Candidate WHERE dni = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, dni);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setDni(rs.getString("dni"));
				obj.setName(rs.getString("name"));
				obj.setSurname(rs.getString("surname"));
				obj.setEmail(rs.getString("email"));
				obj.setBirthDate(rs.getString("birthDate"));
				obj.setCurriculum(rs.getString("curriculum"));
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
	public ArrayList<Candidato> buscarXNombreOApellido(String filtro) {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
		 	cn = MySQLConnection.getConnection();
		 	String sql = "SELECT * FROM tb_Candidate WHERE name LIKE ? OR surname LIKE ?";
		 	stm = cn.prepareStatement(sql);
		 	stm.setString(1, "%" + filtro + "%");
		 	stm.setString(2, "%" + filtro + "%");
		 	rs = stm.executeQuery();
		 	while (rs.next()) {
		 		Candidato obj = new Candidato();
		 		obj.setDni(rs.getString("dni"));
		 		obj.setName(rs.getString("name"));
		 		obj.setSurname(rs.getString("surname"));
		 		obj.setEmail(rs.getString("email"));
		 		obj.setBirthDate(rs.getString("birthDate"));
		 		obj.setCurriculum(rs.getString("curriculum"));
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
	public ArrayList<Candidato> buscarXDNI(String filtro) {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
		 	cn = MySQLConnection.getConnection();
		 	String sql = "SELECT * FROM tb_Candidate WHERE dni LIKE ?";
		 	stm = cn.prepareStatement(sql);
		 	stm.setString(1, "%" + filtro + "%");
		 	rs = stm.executeQuery();
		 	while (rs.next()) {
		 		Candidato obj = new Candidato();
		 		obj.setDni(rs.getString("dni"));
		 		obj.setName(rs.getString("name"));
		 		obj.setSurname(rs.getString("surname"));
		 		obj.setEmail(rs.getString("email"));
		 		obj.setBirthDate(rs.getString("birthDate"));
		 		obj.setCurriculum(rs.getString("curriculum"));
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

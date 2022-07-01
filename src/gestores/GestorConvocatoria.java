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

	@Override
	public int registrar(Convocatoria obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO tb_Proposal(name, description, startDate, endDate, position, idArea) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1,obj.getName());
			stm.setString(2,obj.getDescription());
			stm.setString(3,obj.getStartDate());
			stm.setString(4,obj.getEndDate());
			stm.setString(5,obj.getPosition());
			stm.setInt(6,obj.getArea().getId());
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
	public int actualizar(Convocatoria obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE tb_Proposal SET name = ?, description = ?, startDate = ?, endDate = ?, position = ?, idArea = ?  "
					+ "WHERE id = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1,obj.getName());
			stm.setString(2,obj.getDescription());
			stm.setString(3,obj.getStartDate());
			stm.setString(4,obj.getEndDate());
			stm.setString(5,obj.getPosition());
			stm.setInt(6,obj.getArea().getId());
			stm.setInt(7,obj.getId());
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
	public int eliminar(int codigo) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "DELETE FROM tb_Proposal WHERE id = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, codigo);
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
	public Convocatoria obtener(int id) {
		Convocatoria obj = new Convocatoria();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal WHERE id = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setDescription(rs.getString("Description"));
				obj.setStartDate(rs.getString("startDate"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setPosition(rs.getString("position"));
				obj.setArea(gestorArea.obtener(rs.getInt("idArea")) );
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
	public ArrayList<Convocatoria> buscarxNombre(String filtro) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal WHERE name LIKE ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, "%" + filtro + "%");
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

	@Override
	public ArrayList<Convocatoria> buscarxArea(String filtro) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal p JOIN tb_Area a ON a.id = p.idArea WHERE a.name LIKE ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, "%" + filtro + "%");
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

	@Override
	public ArrayList<Convocatoria> buscarxDia(String inicio, String fin) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal WHERE startDate  <= ? AND endDate  >= ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, inicio );
			stm.setString(2,  fin );
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

	@Override
	public ArrayList<Convocatoria> buscarxNombreExacto(String filtro) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Proposal WHERE name LIKE ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1,filtro);
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

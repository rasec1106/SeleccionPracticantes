package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorUsuario;
import model.Usuario;
import util.MySQLConnection;

public class GestorUsuario implements IGestorUsuario {

	@Override
	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_User";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Usuario obj = new Usuario();
				obj.setId(rs.getInt("id"));
				obj.setUsername(rs.getString("username"));
				obj.setPassword(rs.getString("password"));
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
	public Usuario obtener(int id) {

		
		return null;
	}

	@Override
	public Usuario validarAcceso(String username, String password) {
		Usuario user = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * from tb_User WHERE username= ? and password = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1,username);;
			stm.setString(2, password);
			rs = stm.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setIdUserType(rs.getInt("idUserType"));
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
		return user;
	}

	@Override
	public int registrarCandidato(String username, String password) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO tb_User(username, password, idUserType) VALUES (?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			stm.setString(2,password);
			stm.setInt(3, 3);
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

}

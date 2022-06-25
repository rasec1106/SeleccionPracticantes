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
	public boolean validarAcceso(Usuario obj) {
		boolean esValido = false;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_ValidarUsuario(?, ?)}";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getUsername());;
			stm.setString(2, obj.getPassword());
			rs = stm.executeQuery();
			while (rs.next()) {
				esValido = true;
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
		return esValido;
	}

}

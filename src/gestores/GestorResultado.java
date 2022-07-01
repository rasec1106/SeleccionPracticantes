package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorResultado;
import model.Convocatoria;
import model.Resultado;
import util.MySQLConnection;

public class GestorResultado implements IGestorResultado {

	@Override
	public ArrayList<Resultado> listarResultados(Convocatoria convocatoria) {
		ArrayList<Resultado> lista = new ArrayList<Resultado>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT tc.* FROM tb_Test_Candidate tc JOIN tb_Test t on t.id = tc.idTest WHERE t.idProposal = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, convocatoria.getId());
			rs = stm.executeQuery();
			while (rs.next()) {
				Resultado obj = new Resultado();
				obj.setCandidate(new GestorCandidato().obtener(rs.getString("dniCandidate")));
				obj.setTest(new GestorPrueba().obtener(rs.getInt("idTest")));
				obj.setScore(rs.getInt("score"));
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

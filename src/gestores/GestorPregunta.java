package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorPregunta;
import model.Pregunta;
import util.MySQLConnection;

public class GestorPregunta implements IGestorPregunta {

	@Override
	public ArrayList<Pregunta> listarPreguntasXConvocatoria(int idConvocatoria) {
		ArrayList<Pregunta> lista = new ArrayList<Pregunta>();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tb_Question WHERE idTest = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, idConvocatoria);
			rs = stm.executeQuery();
			while (rs.next()) {
				Pregunta obj = new Pregunta();
				obj.setId(rs.getInt("id"));
				obj.setQuestion(rs.getString("question"));
				obj.setOptionA(rs.getString("optionA"));
				obj.setOptionB(rs.getString("optionB"));
				obj.setOptionC(rs.getString("optionC"));
				obj.setOptionD(rs.getString("optionD"));
				obj.setAnswer(rs.getString("answer"));
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
	public int registrarPreguntas(ArrayList<Pregunta> preguntas, int idTest) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;		
		try {
			cn = MySQLConnection.getConnection();
			for(Pregunta p : preguntas) {				
				String sql = "INSERT INTO tb_Question(question, optionA, optionB, optionC, optionD, answer, idTest) VALUES (?,?,?,?,?,?,?)";
				stm = cn.prepareStatement(sql);
				stm.setString(1,p.getQuestion());
				stm.setString(2,p.getOptionA());
				stm.setString(3,p.getOptionB());
				stm.setString(4,p.getOptionC());
				stm.setString(5,p.getOptionD());
				stm.setString(6,p.getAnswer());
				stm.setInt(7,idTest);
				resultado = stm.executeUpdate();
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

}

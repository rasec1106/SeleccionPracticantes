package interfaces;

import java.util.ArrayList;

import model.Pregunta;

public interface IGestorPregunta {
	
	public ArrayList<Pregunta> listarPreguntasXConvocatoria(int idConvocatoria);
	public int registrarPreguntas(ArrayList<Pregunta> preguntas, int idTest);

}

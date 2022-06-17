package interfaces;

import java.util.ArrayList;

import model.Pregunta;

public interface IGestorPregunta {
	
	public ArrayList<Pregunta> listarPreguntasXConvocatoria(int idConvocatoria);

}

package interfaces;

import java.util.ArrayList;

import model.Convocatoria;
import model.Resultado;

public interface IGestorResultado {
	public ArrayList<Resultado> listarResultados (Convocatoria convocatoria);
}

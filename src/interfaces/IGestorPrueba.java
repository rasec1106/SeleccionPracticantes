package interfaces;

import java.util.ArrayList;

import model.Candidato;
import model.Convocatoria;
import model.Prueba;

public interface IGestorPrueba {
	
	public Prueba obtener(int id);
	public ArrayList<Prueba> listarxConvocatoria (int filtro);
	public int registrar (Prueba prueba, Convocatoria convocatoria);
	public int calificar (Prueba prueba, Candidato candidato );

}

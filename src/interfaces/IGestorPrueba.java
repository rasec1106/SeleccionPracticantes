package interfaces;

import java.util.ArrayList;

import model.Convocatoria;
import model.Prueba;

public interface IGestorPrueba {
	
	public Prueba obtener(int id);
	public ArrayList<Prueba> listarxConvocatoria (int filtro);

}

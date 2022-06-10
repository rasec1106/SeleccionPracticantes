package interfaces;

import java.util.ArrayList;

import model.Convocatoria;

public interface IGestorConvocatoria {
	public ArrayList<Convocatoria> listar();
	
	public int registrar (Convocatoria obj);
	
	public int actualizar (Convocatoria obj);
	
	public int eliminar (int codigo);
	
	public Convocatoria obtener(int id);

}

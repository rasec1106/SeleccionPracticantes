package interfaces;

import java.util.ArrayList;

import model.Area;
import model.Convocatoria;

public interface IGestorArea {
	public ArrayList<Area> listar();
	
	public Area obtener(int id);

}

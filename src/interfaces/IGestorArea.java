package interfaces;

import java.util.ArrayList;

import model.Area;

public interface IGestorArea {
	
	public ArrayList<Area> listar();	
	public Area obtener(int id);

}

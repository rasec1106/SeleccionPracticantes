package interfaces;

import model.ListaPruebas;
import java.util.ArrayList;

public interface IGestorListaPruebas {
	public ArrayList<ListaPruebas> listar();
	public ArrayList<ListaPruebas> buscarXID(String filtro);
	public ArrayList<ListaPruebas> buscarXNombre(String filtro);

}

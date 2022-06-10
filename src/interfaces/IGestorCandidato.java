package interfaces;

import java.util.ArrayList;

import model.Candidato;

public interface IGestorCandidato {
	
	public ArrayList<Candidato> listar();	
	public int registrar (Candidato obj);	
	public int actualizar (Candidato obj);	
	public int eliminar (String dni);	
	public Candidato obtener(String dni);
	
}

package interfaces;

import java.util.ArrayList;

import model.Candidato;
import model.Convocatoria;

public interface IGestorCandidato {
	
	public ArrayList<Candidato> listar();	
	public int registrar (Candidato obj);	
	public int actualizar (Candidato obj);	
	public int eliminar (String dni);	
	public Candidato obtener(String dni);
	public ArrayList<Candidato> buscarXNombreOApellido(String filtro);	
	public ArrayList<Candidato> buscarXDNI(String filtro);
	public int registrarseaConvocatoria (Candidato candidate, Convocatoria convocatoria);

	
	
}

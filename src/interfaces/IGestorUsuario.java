package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface IGestorUsuario {
	
	public ArrayList<Usuario> listar();	
	
	public Usuario obtener(int id);
	
	public Usuario validarAcceso(String username, String password);
	public int registrarCandidato(String username, String password);
	
	/*public ArrayList<Usuario> listar();
	
	public int registrar(Usuario obj);
	
	public int actualizar(Usuario obj);
	
	public int eliminar(int codigo);
	
	public Usuario obtener(int id);
	
	public ArrayList<Usuario> buscarXNombreOApellido(String filtro);
	
	public ArrayList<Usuario> buscarXUsuario(String filtro);
	
	public ArrayList<Usuario> buscarUsuarioXTipo(int tipo);*/
	
}

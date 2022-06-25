package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface IGestorUsuario {
	
	public ArrayList<Usuario> listar();	
	
	public Usuario obtener(int id);
	
	public boolean validarAcceso(Usuario obj);
	/*public ArrayList<Usuario> listar();
	
	public int registrar(Usuario obj);
	
	public int actualizar(Usuario obj);
	
	public int eliminar(int codigo);
	
	public Usuario obtener(int id);
	
	public ArrayList<Usuario> buscarXNombreOApellido(String filtro);
	
	public ArrayList<Usuario> buscarXUsuario(String filtro);
	
	public ArrayList<Usuario> buscarUsuarioXTipo(int tipo);*/
	
}

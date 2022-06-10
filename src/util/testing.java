package util;

import java.util.ArrayList;

import gestores.GestorUsuario;
import model.Usuario;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorUsuario gestorUsuario = new GestorUsuario();
		ArrayList<Usuario> lista = gestorUsuario.listar();
		for (Usuario usuario : lista) {
			System.out.println(usuario);
		}
	}

}

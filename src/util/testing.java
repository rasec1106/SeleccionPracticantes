package util;

import gestores.GestorUsuario;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileUtils.openFile(".\\filesDirectory\\CHHV_Curriculum.pdf");
		try {
			int res = new GestorUsuario().registrarCandidato("22222222","cibertec");
			System.out.println(res);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

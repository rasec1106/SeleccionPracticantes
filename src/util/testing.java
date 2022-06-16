package util;

import java.util.ArrayList;

import gestores.GestorUsuario;
import model.Usuario;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileUtils.openFile(".\\filesDirectory\\CHHV_Curriculum.pdf");
		try {
			FileUtils.copyFile(".\\filesDirectory\\CHHV_Curriculum.pdf", ".\\filesDirectory\\CHHV_Curriculum2.pdf");		
			System.out.println("OK");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

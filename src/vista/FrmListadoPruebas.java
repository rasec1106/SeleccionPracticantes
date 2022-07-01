package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmListadoPruebas extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListadoPruebas frame = new FrmListadoPruebas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmListadoPruebas() {
		setTitle("Lista de Pruebas");
		setBounds(100, 100, 493, 345);
		getContentPane().setLayout(null);

	}

}

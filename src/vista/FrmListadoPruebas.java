package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmListadoPruebas extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}

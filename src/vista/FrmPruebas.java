package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmPruebas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPruebas frame = new FrmPruebas();
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
	public FrmPruebas() {
		setBounds(100, 100, 450, 300);

	}

}

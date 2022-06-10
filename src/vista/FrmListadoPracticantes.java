package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmListadoPracticantes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListadoPracticantes frame = new FrmListadoPracticantes();
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
	public FrmListadoPracticantes() {
		setBounds(100, 100, 450, 300);

	}

}

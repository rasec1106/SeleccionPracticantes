package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmConvocatorias extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConvocatorias frame = new FrmConvocatorias();
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
	public FrmConvocatorias() {
		setBounds(100, 100, 450, 300);

	}

}

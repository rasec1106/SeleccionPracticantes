package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmPruebas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private FrmPrincipal mainFrame;

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
	public FrmPruebas(FrmPrincipal frame) {
		this();
		this.mainFrame = frame;
	}

	/**
	 * Create the frame.
	 */
	public FrmPruebas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JButton btnNuevo = new JButton("Nueva Prueba");
		btnNuevo.setBounds(321, 49, 89, 23);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevoActionPerformed(e);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNuevo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(36, 53, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(69, 139, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(213, 188, 46, 14);
		getContentPane().add(lblNewLabel_2);

	}

	protected void btnNuevoActionPerformed(ActionEvent e) {
		FrmPreguntas frame = new FrmPreguntas();
		mainFrame.addInternalFrame(frame);
	}
}

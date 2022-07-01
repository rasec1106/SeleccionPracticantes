package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestores.GestorUsuario;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(59, 31, 49, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(38, 59, 70, 14);
		contentPane.add(lblContrasenia);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(133, 56, 96, 20);
		contentPane.add(txtPassword);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(133, 28, 96, 20);
		contentPane.add(txtUser);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCrearCuentaActionPerformed(e);
			}
		});
		btnCrearCuenta.setBounds(256, 55, 131, 23);
		contentPane.add(btnCrearCuenta);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIniciarSesionActionPerformed(e);
			}
		});
		btnIniciarSesion.setBounds(256, 27, 131, 23);
		contentPane.add(btnIniciarSesion);
	}

	protected void btnIniciarSesionActionPerformed(ActionEvent e) {
		@SuppressWarnings("deprecation")
		Usuario user = new GestorUsuario().validarAcceso(txtUser.getText(), txtPassword.getText());
		if(user == null) JOptionPane.showMessageDialog(this, "Credenciales invalidas");
		else {
			JFrame principal = new FrmPrincipal(user);
			principal.setVisible(true);
			this.setVisible(false);
		}
	}
	protected void btnCrearCuentaActionPerformed(ActionEvent e) {
		JFrame registro = new FrmRegistro();
		registro.setVisible(true);
	}
}

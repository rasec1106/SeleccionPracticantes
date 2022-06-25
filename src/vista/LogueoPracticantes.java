package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;

public class LogueoPracticantes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JButton btnIniciarSesion;
	private JButton btnCrearCuenta;
	private JTextField txtUsuario;
	
	//Definiendo internal Frame
	private FrmCandidatos frmCandidatos = new FrmCandidatos();
	private JDesktopPane registroPracticantes;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogueoPracticantes frame = new LogueoPracticantes();
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
	public LogueoPracticantes() {
		setTitle("Selecci\u00F3n de Practicantes - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(116, 41, 49, 14);
		contentPane.add(lblUsuario);
		
		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(116, 87, 70, 14);
		contentPane.add(lblContraseña);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(161, 133, 131, 23);
		contentPane.add(btnIniciarSesion);
		
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(this);
		btnCrearCuenta.setBounds(384, 37, 131, 23);
		contentPane.add(btnCrearCuenta);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(239, 38, 96, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		registroPracticantes = new JDesktopPane();
		registroPracticantes.setBounds(10, 167, 841, 533);
		contentPane.add(registroPracticantes);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(239, 84, 96, 20);
		contentPane.add(txtContrasena);
		this.inicializarVentanas();
	}
	
	private void inicializarVentanas() {
		registroPracticantes.add(frmCandidatos);
		frmCandidatos.setVisible(false);	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
		if (e.getSource() == btnCrearCuenta) {
			actionPerformedBtnCrearCuenta(e);
		}
	}
	protected void actionPerformedBtnCrearCuenta(ActionEvent e) {
		frmCandidatos.setVisible(true);
	}
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
	}
}

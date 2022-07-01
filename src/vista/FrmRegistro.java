package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import gestores.GestorCandidato;
import gestores.GestorUsuario;
import model.Candidato;
import util.FileUtils;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JLabel lblCV;
	private File selectedFile = null;
	private GestorCandidato gestor = new GestorCandidato();
	private JDateChooser dateNacimiento;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE PRACTICANTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 11, 236, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dni");
		lblNewLabel_1.setBounds(36, 61, 142, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres");
		lblNewLabel_1_1.setBounds(36, 98, 142, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos");
		lblNewLabel_1_2.setBounds(36, 133, 142, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(36, 168, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_3.setBounds(36, 210, 142, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Curriculum");
		lblNewLabel_1_4.setBounds(36, 264, 142, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnCurriculum = new JButton("Adjuntar CV");
		btnCurriculum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCurriculumActionPerformed(e);
			}
		});
		btnCurriculum.setBounds(172, 260, 143, 23);
		contentPane.add(btnCurriculum);
		
		lblCV = new JLabel("No existe archivo asociado a este candidato");
		lblCV.setEnabled(false);
		lblCV.setBounds(172, 294, 280, 14);
		contentPane.add(lblCV);
		
		dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(172, 210, 143, 20);
		contentPane.add(dateNacimiento);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(172, 165, 143, 20);
		contentPane.add(txtEmail);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(172, 130, 143, 20);
		contentPane.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(172, 95, 143, 20);
		contentPane.add(txtNombre);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtDniKeyReleased(e);
			}
		});
		txtDni.setColumns(10);
		txtDni.setBounds(172, 61, 143, 20);
		contentPane.add(txtDni);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarActionPerformed(e);
			}
		});
		btnRegistrar.setBounds(119, 403, 130, 46);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setBounds(36, 342, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setBounds(36, 375, 74, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtUser = new JTextField();
		txtUser.setEnabled(false);
		txtUser.setBounds(172, 339, 143, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(172, 372, 143, 20);
		contentPane.add(txtPassword);
	}

	@SuppressWarnings("deprecation")
	protected void btnRegistrarActionPerformed(ActionEvent e) {
		try {
			
		Candidato obj = getDataFromForm();		
		int resultado = gestor.registrar(obj);		
		if (resultado == 1) {
			if(selectedFile != null) {
				copyFile(selectedFile);
			}
			int res = new GestorUsuario().registrarCandidato(txtDni.getText(), txtPassword.getText());
			if(res == 1) {
				JOptionPane.showMessageDialog(this, "Se registro el candidato");
				this.setVisible(false);			
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo registrar el candidato");
		}
		}catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	private Candidato getDataFromForm() {
		Candidato obj = new Candidato();
		obj.setDni(txtDni.getText());
		obj.setName(txtNombre.getText());
		obj.setSurname(txtApellido.getText());
		obj.setEmail(txtEmail.getText());
		obj.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").format(dateNacimiento.getDate()));
		obj.setCurriculum(lblCV.getText());
		return obj;
	}
	protected void btnCurriculumActionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		lblCV.setText(selectedFile.getName());
	}
	
	private int copyFile(File file) {
		int result = 1;
		try {
			FileUtils.copyFile(file.getAbsolutePath(), file.getName());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Hubo un error al subir el curriculum");
			result = -1;
		}
		return result;
	}
	protected void txtDniKeyReleased(KeyEvent e) {
		txtUser.setText(txtDni.getText());
	}
}

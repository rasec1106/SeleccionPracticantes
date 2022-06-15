package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

public class FrmListadoPracticantes extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblBuscar;
	private JComboBox<String> cboCategoria;
	private JTextField txtFiltro;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblPracticantes;

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
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Lista de Practicantes");
		setBounds(100, 100, 493, 300);
		getContentPane().setLayout(null);
		
		lblBuscar = new JLabel("Buscar por:");
		lblBuscar.setBounds(10, 11, 87, 14);
		getContentPane().add(lblBuscar);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Mostrar todos", "Nombre o Apellido", "Usuario"}));
		cboCategoria.setBounds(91, 7, 114, 22);
		getContentPane().add(cboCategoria);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(215, 8, 159, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(384, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 463, 215);
		getContentPane().add(scrollPane);
		
		tblPracticantes = new JTable();
		tblPracticantes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Correo", "Curriculum"
			}
		));
		scrollPane.setViewportView(tblPracticantes);

	}
}

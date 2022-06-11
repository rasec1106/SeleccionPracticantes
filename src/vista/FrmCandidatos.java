package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class FrmPracticantes extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTable tblListaPrac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPracticantes frame = new FrmPracticantes();
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
	public FrmPracticantes() {
		setTitle("PRACTICANTES");
		setBounds(100, 100, 555, 562);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE PRACTICANTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 33, 236, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id de Practicante");
		lblNewLabel_1.setBounds(22, 86, 142, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres");
		lblNewLabel_1_1.setBounds(22, 136, 142, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos");
		lblNewLabel_1_2.setBounds(22, 186, 142, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Edad");
		lblNewLabel_1_3.setBounds(22, 236, 142, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Convocatoria");
		lblNewLabel_1_4.setBounds(22, 286, 142, 14);
		getContentPane().add(lblNewLabel_1_4);
		
		txtID = new JTextField();
		txtID.setBounds(233, 83, 143, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(233, 133, 143, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(233, 183, 143, 20);
		getContentPane().add(txtApellidos);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(233, 233, 143, 20);
		getContentPane().add(txtEdad);
		
		JComboBox cboConvocatoria = new JComboBox();
		cboConvocatoria.setBounds(233, 282, 143, 22);
		getContentPane().add(cboConvocatoria);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(424, 82, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(424, 132, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(424, 186, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 344, 507, 177);
		getContentPane().add(scrollPane);
		
		tblListaPrac = new JTable();
		tblListaPrac.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Edad", "Convocatoria"
			}
		));
		tblListaPrac.getColumnModel().getColumn(0).setPreferredWidth(65);
		tblListaPrac.getColumnModel().getColumn(1).setPreferredWidth(137);
		tblListaPrac.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblListaPrac.getColumnModel().getColumn(3).setPreferredWidth(42);
		tblListaPrac.getColumnModel().getColumn(4).setPreferredWidth(131);
		scrollPane.setViewportView(tblListaPrac);

	}
}

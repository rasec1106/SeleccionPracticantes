package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gestores.GestorCandidato;
import model.Candidato;
import util.FileUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmListadoPracticantes extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblBuscar;
	private JComboBox<String> cboCategoria;
	private JTextField txtFiltro;
	private JScrollPane scrollPane;
	private JTable tblPracticantes;
	private JButton btnBuscar;
	private JButton btnNewButton;
	
	private String selectedCV = "";

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
		setBounds(100, 100, 493, 345);
		getContentPane().setLayout(null);
		
		lblBuscar = new JLabel("Buscar por:");
		lblBuscar.setBounds(10, 11, 87, 14);
		getContentPane().add(lblBuscar);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Mostrar todos", "Nombre o Apellido", "DNI"}));
		cboCategoria.setBounds(91, 7, 114, 22);
		getContentPane().add(cboCategoria);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(215, 8, 159, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 463, 215);
		getContentPane().add(scrollPane);
		
		tblPracticantes = new JTable();
		tblPracticantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblPracticantesMouseClicked(e);
			}
		});
		tblPracticantes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Correo", "Curriculum"
			}
		));
		scrollPane.setViewportView(tblPracticantes);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarActionPerformed(e);
			}
		});
		btnBuscar.setBounds(384, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnNewButton = new JButton("Ver CV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(378, 271, 89, 23);
		getContentPane().add(btnNewButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void listarPracticantes(ArrayList<Candidato> lista) {
	 	DefaultTableModel modelo = (DefaultTableModel) tblPracticantes.getModel();
	 	modelo.getDataVector().clear();
		
	 	for(Candidato obj : lista) {
	 		Object[] data = {obj.getName(), obj.getSurname(), obj.getEmail(), obj.getCurriculum()};
	 		modelo.addRow(data);
	 	}
	}

	protected void btnBuscarActionPerformed(ActionEvent e) {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		GestorCandidato gestor = new GestorCandidato();
		
		switch (cboCategoria.getSelectedIndex()) {
		case 0:
		 	lista = gestor.listar();
		 	break;
		case 1:
		 	lista = gestor.buscarXNombreOApellido(txtFiltro.getText());
		 	break;
		case 2:
		 	lista = gestor.buscarXDNI(txtFiltro.getText());
		default:
		 	break;
		}
		listarPracticantes(lista);
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		try {
			FileUtils.openFile(selectedCV);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}
	protected void tblPracticantesMouseClicked(MouseEvent e) {
		selectedCV = (String) tblPracticantes.getValueAt(tblPracticantes.getSelectedRow(), 3);
	}
}

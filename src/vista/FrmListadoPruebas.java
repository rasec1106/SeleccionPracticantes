package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorListaPruebas;
import model.ListaPruebas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmListadoPruebas extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblBuscar;
	private JComboBox<String> cboCategoria;
	private JTextField txtFiltro;
	private JButton btnBuscarPrueba;
	private JScrollPane scrollPane;
	private JTable tblPruebas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListadoPruebas frame = new FrmListadoPruebas();
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
	public FrmListadoPruebas() {
		setTitle("Lista de Pruebas");
		setBounds(100, 100, 493, 345);
		getContentPane().setLayout(null);
		
		lblBuscar = new JLabel("Buscar por:");
		lblBuscar.setBounds(10, 15, 87, 14);
		getContentPane().add(lblBuscar);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Mostrar todos", "ID", "Nombre Convocatoria"}));
		cboCategoria.setBounds(91, 11, 114, 22);
		getContentPane().add(cboCategoria);
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(215, 12, 159, 20);
		getContentPane().add(txtFiltro);
		
		btnBuscarPrueba = new JButton("Buscar");
		btnBuscarPrueba.addActionListener(this);
		btnBuscarPrueba.setBounds(384, 11, 89, 23);
		getContentPane().add(btnBuscarPrueba);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 463, 215);
		getContentPane().add(scrollPane);
		
		tblPruebas = new JTable();
		tblPruebas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblPruebas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Convocatoria"
			}
		));
		scrollPane.setViewportView(tblPruebas);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarPrueba) {
			actionPerformedBtnBuscarPrueba(e);
		}
	}
	
	private void listarPruebas(ArrayList<ListaPruebas> lista) {
	 	DefaultTableModel modelo = (DefaultTableModel) tblPruebas.getModel();
	 	modelo.getDataVector().clear();
		
	 	for(ListaPruebas obj : lista) {
	 		Object[] data = {obj.getId(), obj.getName(), obj.getNameProposal()};
	 		modelo.addRow(data);
	 	}
	}
	protected void actionPerformedBtnBuscarPrueba(ActionEvent e) {
		ArrayList<ListaPruebas> lista = new ArrayList<ListaPruebas>();
		GestorListaPruebas gestor = new GestorListaPruebas();
		
		switch (cboCategoria.getSelectedIndex()) {
		case 0:
		 	lista = gestor.listar();
		 	break;
		case 1:
		 	lista = gestor.buscarXID(txtFiltro.getText());
		 	break;
		case 2:
		 	lista = gestor.buscarXNombre(txtFiltro.getText());
		default:
		 	break;
		}
		listarPruebas(lista);
	}
}

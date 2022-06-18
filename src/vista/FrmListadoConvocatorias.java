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

import gestores.GestorConvocatoria;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.Convocatoria;



public class FrmListadoConvocatorias extends JInternalFrame {
	private JTextField txtFiltro;
	private JTable tblLista;
	private JComboBox cboBusqueda;
	

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListadoConvocatorias frame = new FrmListadoConvocatorias();
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
	public FrmListadoConvocatorias() {
		setTitle("Listado de Convocatorias");
		setBounds(100, 100, 692, 347);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar por");
		lblNewLabel.setBounds(10, 11, 74, 14);
		getContentPane().add(lblNewLabel);
		
		cboBusqueda = new JComboBox();
		cboBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Mostrar todos", "Nombre", "Dia de Inicio / Fin", "Area"}));
		cboBusqueda.setBounds(82, 7, 142, 22);
		getContentPane().add(cboBusqueda);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(268, 8, 171, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setBounds(539, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 656, 259);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Descripcion", "Dia de Inicio", "Dia de Fin", "Posicion", "Area"
			}
		));
		scrollPane.setViewportView(tblLista);

	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		GestorConvocatoria gestor = new GestorConvocatoria();

		
		switch (cboBusqueda.getSelectedIndex()) {
		case 0:
			lista = gestor.listar();
			break;
		case 1:
			lista = gestor.buscarxNombre(txtFiltro.getText());
			break;
		case 2:
			lista = gestor.buscarxDia(txtFiltro.getText());
			break;
		case 3:
			lista = gestor.buscarxArea(txtFiltro.getText());
		default:
			break;
		
		}
		listarConvocatoria(lista);

	}
	
	private void listarConvocatoria(ArrayList<Convocatoria> lista) {
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();
		
		for(Convocatoria obj : lista) {
			Object[] data = {obj.getId(), obj.getName(), obj.getDescription(), obj.getStartDate(), obj.getEndDate(), obj.getPosition(), obj.getArea()};
			modelo.addRow(data);
		}
	}
	
	
	
	
	
}

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.Convocatoria;
import com.toedter.calendar.JDateChooser;





public class FrmListadoConvocatorias extends JInternalFrame {
	private JTextField txtFiltro;
	private JTable tblLista;
	private JComboBox<String> cboBusqueda;
	
	

	private static final long serialVersionUID = 1L;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;

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
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Listado de Convocatorias");
		setBounds(100, 100, 692, 343);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar por");
		lblNewLabel.setBounds(10, 11, 74, 14);
		getContentPane().add(lblNewLabel);
		
		cboBusqueda = new JComboBox<String>();
		cboBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCboBusqueda(e);
			}
		});
		cboBusqueda.setModel(new DefaultComboBoxModel<String>(new String[] {"Mostrar todos", "Nombre", "Dia ", "Area"}));
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
		scrollPane.setBounds(10, 70, 656, 225);
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
		
		dateInicio = new JDateChooser();
		dateInicio.setDateFormatString("yyyy-MM-dd");
		dateInicio.setBounds(82, 39, 142, 20);
		getContentPane().add(dateInicio);
		dateInicio.setEnabled(false);
		
		dateFin = new JDateChooser();
		dateFin.setDateFormatString("yyyy-MM-dd");
		dateFin.setBounds(268, 39, 171, 20);
		getContentPane().add(dateFin);
		dateFin.setEnabled(false);
		
		
		

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
			lista = gestor.buscarxDia(new SimpleDateFormat("yyyy-MM-dd").format(dateInicio.getDate()),new SimpleDateFormat("yyyy-MM-dd").format(dateFin.getDate()));
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
	protected void actionPerformedCboBusqueda(ActionEvent e) {
		switch (cboBusqueda.getSelectedIndex()) {
		case 0:
			dateInicio.setEnabled(false);
			dateFin.setEnabled(false);
			txtFiltro.setEnabled(true);
			break;
		case 1:
			dateInicio.setEnabled(false);
			dateFin.setEnabled(false);
			txtFiltro.setEnabled(true);
			break;
		case 2:
			dateInicio.setEnabled(true);
			dateFin.setEnabled(true);
			txtFiltro.setEnabled(false);
			break;
		case 3:
			dateInicio.setEnabled(false);
			dateFin.setEnabled(false);
			txtFiltro.setEnabled(true);
		default:
			break;
		
		}
	}
}

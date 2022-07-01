package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorConvocatoria;
import model.Convocatoria;

import javax.swing.JButton;

public class FrmRendirPrueba extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblLista;
	
	private GestorConvocatoria gestorConvocatoria = new GestorConvocatoria();
	private ArrayList<Convocatoria> listaConvocatorias = gestorConvocatoria.listar();
	private JComboBox<Convocatoria> cboConvocatoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRendirPrueba frame = new FrmRendirPrueba();
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
	public FrmRendirPrueba() {
		setTitle("Rendir Prueba");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 447, 286);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convocatoria");
		lblNewLabel.setBounds(29, 33, 84, 14);
		getContentPane().add(lblNewLabel);
		
		cboConvocatoria = new JComboBox<Convocatoria>();
		cboConvocatoria.setBounds(123, 29, 187, 22);
		getContentPane().add(cboConvocatoria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 81, 374, 107);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre"
			}
		));
		scrollPane.setViewportView(tblLista);
		
		JButton btnRendirPrueba = new JButton("Rendir Prueba");
		btnRendirPrueba.setBounds(261, 199, 142, 23);
		getContentPane().add(btnRendirPrueba);
		CargarCboConvocatoria();

	}
	
	private void CargarCboConvocatoria() {
		cboConvocatoria.removeAllItems();
		
		for(Convocatoria convocatoria: listaConvocatorias) {
			cboConvocatoria.addItem(convocatoria);
		}
	}
}

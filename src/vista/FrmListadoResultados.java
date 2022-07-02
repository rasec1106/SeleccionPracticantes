package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorConvocatoria;

import gestores.GestorResultado;
import model.Convocatoria;

import model.Resultado;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class FrmListadoResultados extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblLista;
	private JComboBox<Convocatoria> cboConvocatoria;
	private ArrayList<Convocatoria> listaConvocatorias = new GestorConvocatoria().listar();
	private JButton btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListadoResultados frame = new FrmListadoResultados();
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
	public FrmListadoResultados() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convocatoria");
		lblNewLabel.setBounds(10, 11, 73, 14);
		getContentPane().add(lblNewLabel);
		
		cboConvocatoria = new JComboBox<Convocatoria>();
		cboConvocatoria.setBounds(93, 7, 137, 22);
		getContentPane().add(cboConvocatoria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 201);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Prueba", "Candidato", "Puntaje"
			}
		));
		scrollPane.setViewportView(tblLista);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListarActionPerformed(e);
			}
		});
		btnListar.setBounds(267, 7, 89, 23);
		getContentPane().add(btnListar);
		CargarCboConvocatoria();
	}
	
	private void CargarCboConvocatoria() {
		cboConvocatoria.removeAllItems();
		
		for(Convocatoria convocatoria: listaConvocatorias) {
			cboConvocatoria.addItem(convocatoria);
		}
		cboConvocatoria.setSelectedIndex(0);
	}
	
	private void cargarLista() {
		Convocatoria c = (Convocatoria) cboConvocatoria.getSelectedItem();
		if(c== null) return;
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.setRowCount(0);
		modelo.getDataVector().clear();	
		
		ArrayList<Resultado> lista = new GestorResultado().listarResultados(c);
		for(Resultado obj : lista) {
			Object[] data = {obj.getTest().getName(), obj.getCandidate().getName(), obj.getScore()};
			modelo.addRow(data);
		}
	}
	protected void cboConvocatoriaActionPerformed(ActionEvent e) {
		cargarLista();
	}
	protected void btnListarActionPerformed(ActionEvent e) {
		cargarLista();
	}
}

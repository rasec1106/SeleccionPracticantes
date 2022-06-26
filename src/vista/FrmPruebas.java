package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gestores.GestorArea;
import gestores.GestorConvocatoria;
import gestores.GestorPrueba;
import model.Area;
import model.Convocatoria;
import model.Prueba;

import javax.swing.table.DefaultTableModel;

public class FrmPruebas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private FrmPrincipal mainFrame;
	private JTable tblLista;
	private JComboBox cboConvocatoria;
	
	private GestorConvocatoria gestorConvocatoria = new GestorConvocatoria();
	private ArrayList<Convocatoria> listaConvocatorias = gestorConvocatoria.listar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPruebas frame = new FrmPruebas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FrmPruebas(FrmPrincipal frame) {
		this();
		this.mainFrame = frame;
	}

	/**
	 * Create the frame.
	 */
	public FrmPruebas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 542, 419);
		
		JButton btnNuevo = new JButton("Nueva Prueba");
		btnNuevo.setBounds(393, 45, 123, 23);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevoActionPerformed(e);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNuevo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 104, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("PRUEBAS DE CONOCIMIENTO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 220, 23);
		getContentPane().add(lblNewLabel_3);
		
		cboConvocatoria = new JComboBox();
		cboConvocatoria.setBounds(141, 45, 242, 22);
		getContentPane().add(cboConvocatoria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 373, 300);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre"
			}
		));
		scrollPane.setViewportView(tblLista);
		
		JLabel lblNewLabel = new JLabel("Por Convocatoria");
		lblNewLabel.setBounds(10, 49, 109, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(393, 79, 123, 23);
		getContentPane().add(btnNewButton);
		CargarCboConvocatoria();

	}

	protected void btnNuevoActionPerformed(ActionEvent e) {
		FrmPreguntas frame = new FrmPreguntas();
		mainFrame.addInternalFrame(frame);
	}
	
	private void CargarCboConvocatoria() {
		cboConvocatoria.removeAllItems();
		
		for(Convocatoria convocatoria: listaConvocatorias) {
			cboConvocatoria.addItem(convocatoria);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		ArrayList<Prueba> lista = new ArrayList<Prueba>();
		GestorPrueba gestor = new GestorPrueba();

		lista = gestor.listarxConvocatoria(cboConvocatoria.getSelectedIndex());
		

	
	}
}

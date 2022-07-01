package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import gestores.GestorCandidato;
import gestores.GestorConvocatoria;
import model.Candidato;
import model.Convocatoria;
import model.Prueba;
import model.Usuario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;



public class FrmRegistroaConvocatoria extends JInternalFrame {
	private JComboBox cboConvocatoria;
	
	private GestorConvocatoria gestorConvocatoria = new GestorConvocatoria();
	private ArrayList<Convocatoria> listaConvocatorias = gestorConvocatoria.listar();
	private JTable tblLista;
	
	private Candidato candidato;
	
	private File selectedFile = null;
	private GestorCandidato gestor = new GestorCandidato();
	private Convocatoria convocatoriaSeleccionada = null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroaConvocatoria frame = new FrmRegistroaConvocatoria();
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
	public FrmRegistroaConvocatoria() {
		setBounds(100, 100, 667, 263);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Registrarse a una convocatoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(22, 11, 220, 23);
		getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 89, 619, 99);
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
		
		cboConvocatoria = new JComboBox();
		cboConvocatoria.setBounds(22, 45, 260, 22);
		getContentPane().add(cboConvocatoria);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrarse(e);
			}
		});
		btnRegistrarse.setBounds(265, 199, 123, 23);
		getContentPane().add(btnRegistrarse);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setBounds(474, 45, 89, 23);
		getContentPane().add(btnBuscar);
		CargarCboConvocatoria();

	}
	
	public FrmRegistroaConvocatoria(Usuario user) {
		this();
		candidato = candidato;
	}
	
	private void CargarCboConvocatoria() {
		cboConvocatoria.removeAllItems();
		
		for(Convocatoria convocatoria: listaConvocatorias) {
			cboConvocatoria.addItem(convocatoria);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		ArrayList<Convocatoria> lista = new ArrayList<Convocatoria>();
		GestorConvocatoria gestor = new GestorConvocatoria();

		convocatoriaSeleccionada = (Convocatoria)cboConvocatoria.getSelectedItem();
		
		String nombre = convocatoriaSeleccionada.getName();
		
		lista = gestor.buscarxNombreExacto(nombre);
	
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
	
	protected void actionPerformedBtnRegistrarse(ActionEvent e) {
		if(convocatoriaSeleccionada == null) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar una convocatoria");
			return;
		}
		
		int resultado = gestor.registrarseaConvocatoria(candidato, convocatoriaSeleccionada);		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(this, "Se registro el candidato");

		} else {
			JOptionPane.showMessageDialog(this, "No se pudo registrar el candidato");
		}

		
	}


	
	
	
}

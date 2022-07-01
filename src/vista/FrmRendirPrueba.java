package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorCandidato;
import gestores.GestorConvocatoria;
import gestores.GestorPrueba;
import model.Convocatoria;
import model.Prueba;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class FrmRendirPrueba extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblLista;
	
	private GestorConvocatoria gestorConvocatoria = new GestorConvocatoria();
	private ArrayList<Convocatoria> listaConvocatorias = gestorConvocatoria.listar();
	private JComboBox<Convocatoria> cboConvocatoria;
	private Usuario usuario;
	private int selectedTestId = -1;
	private FrmPrincipal mainFrame;

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
	public FrmRendirPrueba(Usuario user, FrmPrincipal frame) {
		this();
		mainFrame = frame;
		usuario = user;
		listaConvocatorias = gestorConvocatoria.listarXCandidato(new GestorCandidato().obtener(usuario.getUsername()));
		CargarCboConvocatoria();
	}

	/**
	 * Create the frame.
	 */
	public FrmRendirPrueba() {
		setResizable(true);
		setRootPaneCheckingEnabled(false);
		setNormalBounds(new Rectangle(100, 100, 447, 286));
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
		cboConvocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboConvocatoriaActionPerformed(e);
			}
		});
		cboConvocatoria.setBounds(123, 29, 187, 22);
		getContentPane().add(cboConvocatoria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 81, 374, 107);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblListaMouseClicked(e);
			}
		});
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre"
			}
		));
		scrollPane.setViewportView(tblLista);
		
		JButton btnRendirPrueba = new JButton("Rendir Prueba");
		btnRendirPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRendirPruebaActionPerformed(e);
			}
		});
		btnRendirPrueba.setBounds(261, 199, 142, 23);
		getContentPane().add(btnRendirPrueba);
		CargarCboConvocatoria();

	}
	
	private void CargarCboConvocatoria() {
		cboConvocatoria.removeAllItems();
		
		for(Convocatoria convocatoria: listaConvocatorias) {
			cboConvocatoria.addItem(convocatoria);
		}
		cboConvocatoria.setSelectedIndex(0);
		cargarLista();
	}
	
	private void cargarLista() {
		Convocatoria c = (Convocatoria) cboConvocatoria.getSelectedItem();
		if(c== null) return;
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();
		
		ArrayList<Prueba> lista = new GestorPrueba().listarxConvocatoria(c.getId());
		for(Prueba obj : lista) {
			Object[] data = {obj.getId(), obj.getName()};
			modelo.addRow(data);
		}
	}
	protected void cboConvocatoriaActionPerformed(ActionEvent e) {
		cargarLista();
		selectedTestId = -1;
	}
	
	protected void btnRendirPruebaActionPerformed(ActionEvent e) {
		if(selectedTestId == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una prueba");
			return;
		}
		FrmPrueba prueba = new FrmPrueba(selectedTestId, usuario);
		prueba.setVisible(true);
		mainFrame.addInternalFrame(prueba);
	}
	protected void tblListaMouseClicked(MouseEvent e) {
		selectedTestId = (int)tblLista.getValueAt(tblLista.getSelectedRow(), 0);
	}
}

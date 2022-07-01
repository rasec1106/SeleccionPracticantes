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

import gestores.GestorCandidato;
import gestores.GestorConvocatoria;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.Convocatoria;
import model.Usuario;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.Font;





public class FrmMisConvocatorias_Candidato extends JInternalFrame {
	private JTable tblLista ;
	
	private ArrayList<Convocatoria> lista ;
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMisConvocatorias_Candidato frame = new FrmMisConvocatorias_Candidato();
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
	public FrmMisConvocatorias_Candidato() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Mis Convocatorias");
		setBounds(100, 100, 692, 343);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 656, 141);
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
		
		JLabel lblNewLabel = new JLabel("CONVOCATORIAS A LAS QUE ESTA INSCRITO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 11, 438, 38);
		getContentPane().add(lblNewLabel);
		
		
		

	}
	
	public FrmMisConvocatorias_Candidato(Usuario user) {
		this();
		lista = new GestorConvocatoria().listarXCandidato(new GestorCandidato().obtener(user.getUsername()));
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

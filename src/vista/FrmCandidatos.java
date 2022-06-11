package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorCandidato;
import model.Candidato;
import model.Convocatoria;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCandidatos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTable tblLista;
	private JTextField txtEmail;
	
	private GestorCandidato gestor = new GestorCandidato();
	private JDateChooser dateNacimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCandidatos frame = new FrmCandidatos();
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
	public FrmCandidatos() {
		setTitle("PRACTICANTES");
		setBounds(100, 100, 555, 562);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE PRACTICANTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 33, 236, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dni");
		lblNewLabel_1.setBounds(22, 86, 142, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres");
		lblNewLabel_1_1.setBounds(24, 120, 142, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos");
		lblNewLabel_1_2.setBounds(24, 155, 142, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_3.setBounds(24, 232, 142, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Convocatoria");
		lblNewLabel_1_4.setBounds(22, 286, 142, 14);
		getContentPane().add(lblNewLabel_1_4);
		
		txtDni = new JTextField();
		txtDni.setBounds(233, 83, 143, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(233, 117, 143, 20);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(233, 152, 143, 20);
		getContentPane().add(txtApellido);
		
		JComboBox<Convocatoria> cboConvocatoria = new JComboBox<Convocatoria>();
		cboConvocatoria.setBounds(233, 282, 143, 22);
		getContentPane().add(cboConvocatoria);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarActionPerformed(e);
			}
		});
		btnRegistrar.setBounds(424, 82, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarActionPerformed(e);
			}
		});
		btnEditar.setBounds(424, 116, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(424, 151, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 344, 507, 177);
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
				"ID", "Nombres", "Apellidos", "Edad", "Convocatoria"
			}
		));
		tblLista.getColumnModel().getColumn(0).setPreferredWidth(65);
		tblLista.getColumnModel().getColumn(1).setPreferredWidth(137);
		tblLista.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblLista.getColumnModel().getColumn(3).setPreferredWidth(42);
		tblLista.getColumnModel().getColumn(4).setPreferredWidth(131);
		scrollPane.setViewportView(tblLista);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(24, 190, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(233, 187, 143, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(233, 232, 143, 20);
		getContentPane().add(dateNacimiento);
		
		CargarLista();

	}
	private void CargarLista() {
		ArrayList<Candidato> lista = gestor.listar();		
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();		
		for(Candidato obj : lista) {
			Object[] data = {obj.getDni(), obj.getName(), obj.getSurname(), obj.getBirthDate(), obj.getCurriculum()};
			modelo.addRow(data);
		}		
	}
	protected void btnRegistrarActionPerformed(ActionEvent e) {
		Candidato obj = getDataFromForm();		
		int resultado = gestor.registrar(obj);		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(this, "Se registro el candidato");
			CargarLista();
			limpiarFormulario();
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo registrar el candidato");
		}
		limpiarFormulario();
	}
	private void limpiarFormulario() {
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmail.setText("");
		dateNacimiento.setDate(new Date());
	}
	private Candidato getDataFromForm() {
		Candidato obj = new Candidato();
		obj.setDni(txtDni.getText());
		obj.setName(txtNombre.getText());
		obj.setSurname(txtApellido.getText());
		obj.setEmail(txtEmail.getText());
		obj.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").format(dateNacimiento.getDate()));
		return obj;
	}
	protected void btnEditarActionPerformed(ActionEvent e) {
		if(txtDni.getText() != "") {
			Candidato obj = getDataFromForm();			
			int resultado = gestor.actualizar(obj);			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(this, "Se actualizo el candidato");
				CargarLista();
				limpiarFormulario();
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo actualizar el candidato");
			}			
		}
	}
protected void tblListaMouseClicked(MouseEvent e) {
		
		String dni = (String) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
		Candidato c = gestor.obtener(dni);
		setDataToForm(c);		
	}
	
	private void setDataToForm(Candidato obj) {
		try {				
			txtDni.setText(obj.getDni());
			txtNombre.setText(obj.getName());
			txtApellido.setText(obj.getSurname());
			txtEmail.setText(obj.getEmail());
			dateNacimiento.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(obj.getBirthDate()));		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void btnEliminarActionPerformed(ActionEvent e) {
		if(txtDni.getText() != "") {
			if(JOptionPane.showConfirmDialog(null, "Se eliminara el registro seleccionado, ¿Desea continuar?",
					"Convocatorias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String codigo = txtDni.getText();				
				int resultado = gestor.eliminar(codigo);				
				if (resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se elimino el candidato");
					CargarLista();
					limpiarFormulario();
				} else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar el candidato");
				}
			}
		}
	}
}

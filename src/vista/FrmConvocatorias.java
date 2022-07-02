package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gestores.GestorArea;
import gestores.GestorConvocatoria;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Area;
//Importar las clases
import model.Convocatoria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmConvocatorias extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPosicion;
	private JTable tblLista;
	
	private GestorConvocatoria gestor = new GestorConvocatoria();
	private GestorArea gestorArea = new GestorArea();
	private ArrayList<Area> listaAreas = gestorArea.listar();
	
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private JComboBox<Area> cboArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConvocatorias frame = new FrmConvocatorias();
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
	public FrmConvocatorias() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 674, 573);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE CONVOCATORIAS");
		lblNewLabel.setBounds(10, 17, 181, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 48, 118, 14);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 118, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 110, 118, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblDiaDeInicio = new JLabel("Dia de Inicio");
		lblDiaDeInicio.setBounds(10, 141, 118, 14);
		getContentPane().add(lblDiaDeInicio);
		
		JLabel lblDiaDeFin = new JLabel("Dia de Fin");
		lblDiaDeFin.setBounds(10, 172, 118, 14);
		getContentPane().add(lblDiaDeFin);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(10, 203, 118, 14);
		getContentPane().add(lblPosicion);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(10, 234, 118, 14);
		getContentPane().add(lblArea);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(196, 45, 118, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(196, 76, 118, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(196, 107, 118, 20);
		getContentPane().add(txtDescripcion);
		
		dateInicio = new JDateChooser();
		dateInicio.setBounds(196, 138, 118, 20);
		getContentPane().add(dateInicio);
		
		dateFin = new JDateChooser();
		dateFin.setBounds(196, 172, 118, 20);
		getContentPane().add(dateFin);
		
		txtPosicion = new JTextField();
		txtPosicion.setBounds(196, 200, 118, 20);
		getContentPane().add(txtPosicion);
		txtPosicion.setColumns(10);
		
		cboArea = new JComboBox<Area>();
		cboArea.setBounds(196, 234, 118, 22);
		getContentPane().add(cboArea);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setBounds(335, 44, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEditar(e);
			}
		});
		btnEditar.setBounds(335, 75, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setBounds(335, 106, 89, 23);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 295, 638, 237);
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
				"ID", "Nombre", "Descripcion", "Dia de Inicio", "Dia de Fin", "Posicion", "Area"
			}
		));
		scrollPane.setViewportView(tblLista);
		
		CargarLista();
		CargarCboArea();
		limpiarFormulario();
	}
	private void CargarCboArea() {
		cboArea.removeAllItems();
		
		for(Area area: listaAreas) {
			cboArea.addItem(area);
		}
	}
	private void CargarLista() {
		ArrayList<Convocatoria> lista = gestor.listar();		
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();		
		for(Convocatoria obj : lista) {
			Object[] data = {obj.getId(), obj.getName(), obj.getDescription(), obj.getStartDate(), obj.getEndDate(), obj.getPosition(), obj.getArea()};
			modelo.addRow(data);
		}		
	}
	
	private Convocatoria getDataFromForm() {
		Convocatoria obj = new Convocatoria();
		try {
			obj.setId(Integer.parseInt(txtID.getText()));			
		}catch (Exception e) {
			obj.setId(0);
		}
		obj.setName(txtNombre.getText());
		obj.setDescription(txtDescripcion.getText());
		obj.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(dateInicio.getDate()));
		obj.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(dateFin.getDate()));
		obj.setPosition(txtPosicion.getText());
		obj.setArea((Area)cboArea.getSelectedItem());
		return obj;
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		Convocatoria obj = getDataFromForm();		
		int resultado = gestor.registrar(obj);		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(this, "Se registro la convocatoria");
			CargarLista();
			limpiarFormulario();
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo registrar la convocatoria");
		}
		limpiarFormulario();
	}
	private void limpiarFormulario() {
		txtID.setText("");
		txtNombre.setText("");
		txtDescripcion.setText("");
		dateInicio.setDate(new Date());
		dateFin.setDate(new Date());
		txtPosicion.setText("");
		cboArea.setSelectedIndex(-1);
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {		
		if(txtID.getText() != "") {
			Convocatoria obj = getDataFromForm();			
			int resultado = gestor.actualizar(obj);			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(this, "Se actualizo la convocatoria");
				CargarLista();
				limpiarFormulario();
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo actualizar la convocatoria");
			}			
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(txtID.getText() != "") {
			if(JOptionPane.showConfirmDialog(null, "Se eliminara el registro seleccionado, ¿Desea continuar?",
					"Convocatorias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int codigo = Integer.parseInt(txtID.getText());				
				int resultado = gestor.eliminar(codigo);				
				if (resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se elimino la convocatoria");
					CargarLista();
					limpiarFormulario();
				} else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar la convocatoria");
				}
			}
		}
	}
	
	protected void tblListaMouseClicked(MouseEvent e) {
		
		int id = (int) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
		Convocatoria c = gestor.obtener(id);
		setDataToForm(c);		
	}
	
	private void setDataToForm(Convocatoria obj) {
		try {				
			txtID.setText(obj.getId()+"");
			txtNombre.setText(obj.getName());
			txtDescripcion.setText(obj.getDescription());
			dateInicio.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(obj.getStartDate()));
			dateFin.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(obj.getEndDate()));
			txtPosicion.setText(obj.getPosition());
			for(Area a: listaAreas) {
				if (a.getId() == obj.getArea().getId()) {
					cboArea.setSelectedItem(a);
				}
			}			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import gestores.GestorPregunta;
import gestores.GestorPrueba;
import model.Candidato;
import model.Convocatoria;
import model.Pregunta;
import model.Prueba;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmPreguntas extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;
	private JTable tblLista;
	private GestorPrueba gestorPrueba = new GestorPrueba();
	private ArrayList<Pregunta> preguntas;
	private JTextArea txtPregunta;
	private JRadioButton rbA;
	private JRadioButton rbB;
	private JRadioButton rbC;
	private JRadioButton rbD;
	private ButtonGroup bg;
	private JTextField txtNombre;
	private JPanel panel;
	private Convocatoria convocatoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreguntas frame = new FrmPreguntas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FrmPreguntas(Convocatoria c) {
		this();
		convocatoria = c;
	}

	/**
	 * Create the frame.
	 */
	public FrmPreguntas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 932, 660);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pregunta");
		lblNewLabel.setBounds(33, 55, 67, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opcion A");
		lblNewLabel_1.setBounds(33, 120, 67, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Opcion B");
		lblNewLabel_2.setBounds(33, 160, 67, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Opcion C");
		lblNewLabel_3.setBounds(33, 200, 67, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Opcion D");
		lblNewLabel_4.setBounds(33, 240, 67, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Respuesta");
		lblNewLabel_5.setBounds(33, 280, 67, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("LISTADO DE PREGUNTAS");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(92, 370, 235, 23);
		getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 393, 357, 178);
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
				"ID", "Pregunta"
			}
		));
		tblLista.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblLista.getColumnModel().getColumn(0).setMinWidth(30);
		tblLista.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane.setViewportView(tblLista);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(423, 50, 478, 521);
		getContentPane().add(scrollPane_1);
		
		panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		
		JLabel lblNewLabel_7 = new JLabel("VISTA PREVIA");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(570, 23, 189, 21);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActionPerformed(e);
			}
		});
		btnAgregar.setBounds(60, 332, 89, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarActionPerformed(e);
			}
		});
		btnEditar.setBounds(166, 332, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarActionPerformed(e);
			}
		});
		btnEliminar.setBounds(280, 332, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnGuardar = new JButton("GUARDAR PRUEBA");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardarActionPerformed(e);
			}
		});
		btnGuardar.setBounds(125, 582, 189, 37);
		getContentPane().add(btnGuardar);
		
		txtA = new JTextField();
		txtA.setBounds(111, 117, 259, 20);
		getContentPane().add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setBounds(111, 157, 259, 20);
		getContentPane().add(txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(110, 197, 260, 20);
		getContentPane().add(txtC);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		txtD.setBounds(111, 237, 259, 20);
		getContentPane().add(txtD);
		
		rbA = new JRadioButton("A");
		rbA.setHorizontalAlignment(SwingConstants.CENTER);
		rbA.setBounds(100, 276, 54, 23);
		getContentPane().add(rbA);
		
		rbB = new JRadioButton("B");
		rbB.setHorizontalAlignment(SwingConstants.CENTER);
		rbB.setBounds(171, 276, 54, 23);
		getContentPane().add(rbB);
		
		rbC = new JRadioButton("C");
		rbC.setHorizontalAlignment(SwingConstants.CENTER);
		rbC.setBounds(242, 276, 54, 23);
		getContentPane().add(rbC);
		
		rbD = new JRadioButton("D");
		rbD.setHorizontalAlignment(SwingConstants.CENTER);
		rbD.setBounds(313, 276, 54, 23);
		getContentPane().add(rbD);
		
		bg = new ButtonGroup();
		bg.add(rbA);
		bg.add(rbB);
		bg.add(rbC);
		bg.add(rbD);
		
		txtPregunta = new JTextArea();
		txtPregunta.setBounds(110, 50, 259, 56);
		getContentPane().add(txtPregunta);
		txtPregunta.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JLabel lblNewLabel_8 = new JLabel("NOMBRE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(34, 11, 80, 23);
		getContentPane().add(lblNewLabel_8);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(111, 14, 259, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		this.obtenerDatos();
	}
	
	private void obtenerDatos() {
		//prueba = gestorPrueba.obtener(1);
		//preguntas = gestorPregunta.listarPreguntasXConvocatoria(prueba.getId());
		preguntas = new ArrayList<Pregunta>();
		CargarLista();
	}
	private void CargarLista() {	
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();		
		for(Pregunta obj : preguntas) {
			Object[] data = {obj.getId(), obj.getQuestion()};
			modelo.addRow(data);
		}		
		CargarPreview();
	}
	private void CargarPreview() {
		panel.removeAll();
		panel.setLayout(new GridLayout(5*preguntas.size() + 1, 0));
		for(int i=0; i< preguntas.size(); i++) {
			Pregunta p = preguntas.get(i);
			
			JLabel lblNewLabel_2 = new JLabel("Pregunta "+(i+1)+": "+p.getQuestion());
			lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_2.setBounds(100, 10, 480, 20);
			panel.add(lblNewLabel_2);
			
			JRadioButton rbA = new JRadioButton(p.getOptionA());
			rbA.setBounds(50, 0, 109, 23);
			panel.add(rbA);
			
			JRadioButton rbB = new JRadioButton(p.getOptionB());
			rbB.setBounds(50, 0, 109, 23);
			panel.add(rbB);
			
			JRadioButton rbC = new JRadioButton(p.getOptionC());
			rbC.setBounds(50, 0, 109, 23);
			panel.add(rbC);
			
			JRadioButton rbD = new JRadioButton(p.getOptionD());
			rbD.setBounds(50, 0, 109, 23);
			panel.add(rbD);
			
			// Juntamos los botones en un grupo para seleccionar solo 1
			ButtonGroup bg = new ButtonGroup();
			bg.add(rbA);
			bg.add(rbB);
			bg.add(rbC);
			bg.add(rbD);
					
		}
	}
	protected void btnAgregarActionPerformed(ActionEvent e) {
		Pregunta obj = new Pregunta();
		obj.setQuestion(txtPregunta.getText());
		obj.setOptionA(txtA.getText());
		obj.setOptionB(txtB.getText());
		obj.setOptionC(txtC.getText());
		obj.setOptionD(txtD.getText());
		if(rbA.isSelected()) obj.setAnswer("0");
		if(rbB.isSelected()) obj.setAnswer("1");
		if(rbC.isSelected()) obj.setAnswer("2");
		if(rbD.isSelected()) obj.setAnswer("3");
		// Es un objeto nuevo
		obj.setId(0);
		preguntas.add(obj);
		CargarLista();
		LimpiarFormulario();
	}
	private void LimpiarFormulario() {
		txtPregunta.setText("");
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
		txtD.setText("");
		bg.clearSelection();
	}
	protected void tblListaMouseClicked(MouseEvent e) {
		int selectedRow = tblLista.getSelectedRow();
		Pregunta p = preguntas.get(selectedRow);
		setDataToForm(p);
	}
	private void setDataToForm(Pregunta obj) {
		try {				
			txtPregunta.setText(obj.getQuestion());
			txtA.setText(obj.getOptionA());
			txtB.setText(obj.getOptionB());
			txtC.setText(obj.getOptionC());
			txtD.setText(obj.getOptionD());
			bg.clearSelection();
			switch(obj.getAnswer()) {
				case "0": rbA.setSelected(true);; break;
				case "1": rbB.setSelected(true);; break;
				case "2": rbC.setSelected(true);; break;
				case "3": rbD.setSelected(true);; break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void btnEditarActionPerformed(ActionEvent e) {
		int selectedRow = tblLista.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Debe elegir una pregunta de la tabla");
			return;
		}
		Pregunta obj = preguntas.get(selectedRow);
		obj.setQuestion(txtPregunta.getText());
		obj.setOptionA(txtA.getText());
		obj.setOptionB(txtB.getText());
		obj.setOptionC(txtC.getText());
		obj.setOptionD(txtD.getText());
		if(rbA.isSelected()) obj.setAnswer("0");
		if(rbB.isSelected()) obj.setAnswer("1");
		if(rbC.isSelected()) obj.setAnswer("2");
		if(rbD.isSelected()) obj.setAnswer("3");
		CargarLista();
		LimpiarFormulario();
	}
	protected void btnEliminarActionPerformed(ActionEvent e) {
		int selectedRow = tblLista.getSelectedRow();
		if(selectedRow == -1) JOptionPane.showMessageDialog(this, "Debe elegir una pregunta de la tabla");
		preguntas.remove(selectedRow);
		CargarLista();
		LimpiarFormulario();
	}
	protected void btnGuardarActionPerformed(ActionEvent e) {
		Prueba prueba = new Prueba();
		prueba.setName(txtNombre.getText());
		prueba.setQuestions(preguntas);
		int resultado = gestorPrueba.registrar(prueba, convocatoria);
		if (resultado == 1) {
			JOptionPane.showMessageDialog(this, "Se creo la prueba correctamente");
			try {
				this.setClosed(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo crear la prueba");
		}
	}
}

package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import gestores.GestorPregunta;
import gestores.GestorPrueba;
import model.Candidato;
import model.Pregunta;
import model.Prueba;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private GestorPregunta gestorPregunta = new GestorPregunta();
	private Prueba prueba;
	private ArrayList<Pregunta> preguntas;
	
	private JLabel lblTitle;
	private JTextArea txtPregunta;
	private JRadioButton rbA;
	private JRadioButton rbB;
	private JRadioButton rbC;
	private JRadioButton rbD;
	private ButtonGroup bg;

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
		btnEditar.setBounds(166, 332, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(280, 332, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnGuardar = new JButton("GUARDAR PRUEBA");
		btnGuardar.setBounds(125, 582, 189, 37);
		getContentPane().add(btnGuardar);
		
		lblTitle = new JLabel("TITULO");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(33, 16, 357, 28);
		getContentPane().add(lblTitle);
		
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
		
		this.obtenerDatos();
	}
	
	private void obtenerDatos() {
		prueba = gestorPrueba.obtener(1);
		preguntas = gestorPregunta.listarPreguntasXConvocatoria(prueba.getId());
		lblTitle.setText(prueba.getName());
		CargarLista();
	}
	private void CargarLista() {	
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();		
		for(Pregunta obj : preguntas) {
			Object[] data = {obj.getId(), obj.getQuestion()};
			modelo.addRow(data);
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
}

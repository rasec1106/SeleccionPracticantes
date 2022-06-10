package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.components.JSpinField;

public class FrmConvocatorias extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDescripcion;

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
		setBounds(100, 100, 450, 300);
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
		
		JSpinField spinField = new JSpinField();
		spinField.setBounds(196, 141, 118, 20);
		getContentPane().add(spinField);
		
		JSpinField spinField_1 = new JSpinField();
		spinField_1.setBounds(196, 172, 118, 20);
		getContentPane().add(spinField_1);

	}
}

package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import gestores.GestorPrueba;
import model.Pregunta;
import model.Prueba;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class FrmPrueba extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestorPrueba gestor = new GestorPrueba();

	private Prueba pruebaInformatica = gestor.obtener(1);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrueba frame = new FrmPrueba();
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
	public FrmPrueba() {
		setBounds(100, 100, 533, 484);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realizar Prueba de conocimientos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(118, 22, 263, 29);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 80, 490, 360);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		ArrayList<Pregunta> preguntas = pruebaInformatica.getQuestions(); 
		
		for(int i=0; i< preguntas.size(); i++) {
			Pregunta p = preguntas.get(i);
			JLabel lblNewLabel_1 = new JLabel("Pregunta "+(i+1));
			lblNewLabel_1.setBounds(10, 150*i+10, 80, 20);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel(p.getQuestion());
			lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_2.setBounds(100, 150*i+10, 400, 20);
			panel.add(lblNewLabel_2);
			
			JRadioButton rbA = new JRadioButton(p.getOptionA());
			rbA.setBounds(50, 150*i+40, 109, 23);
			panel.add(rbA);
			
			JRadioButton rbB = new JRadioButton(p.getOptionB());
			rbB.setBounds(50, 150*i+70, 109, 23);
			panel.add(rbB);
			
			JRadioButton rbC = new JRadioButton(p.getOptionC());
			rbC.setBounds(50, 150*i+100, 109, 23);
			panel.add(rbC);
			
			JRadioButton rbD = new JRadioButton(p.getOptionD());
			rbD.setBounds(50, 150*i+130, 109, 23);
			panel.add(rbD);
		}
		panel.setBounds(10, 80, 490, 150*preguntas.size());

	}
}

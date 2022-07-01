package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import gestores.GestorCandidato;
import gestores.GestorPrueba;
import model.Pregunta;
import model.Prueba;
import model.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class FrmPrueba extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestorPrueba gestor = new GestorPrueba();

	private Prueba pruebaInformatica;
	private ArrayList<JRadioButton> correctAnswers = new ArrayList<JRadioButton>();
	private Usuario usuario;
	private JPanel panel;
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
	public FrmPrueba(int idTest, Usuario user) {
		this();
		usuario = user;
		pruebaInformatica = gestor.obtener(idTest);
		
		ArrayList<Pregunta> preguntas = pruebaInformatica.getQuestions(); 
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
			
			// Ingresamos la respuesta correcta para validar posteriormente
			switch (p.getAnswer()) {
				case "0": correctAnswers.add(rbA); break;
				case "1": correctAnswers.add(rbB); break;
				case "2": correctAnswers.add(rbC); break;
				case "3": correctAnswers.add(rbD); break;
				default: correctAnswers.add(null);
			}			
		}
	}

	/**
	 * Create the frame.
	 */
	public FrmPrueba() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 479, 473);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realizar Prueba de conocimientos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(118, 22, 263, 29);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 440, 317);
		getContentPane().add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalizarActionPerformed(e);
			}
		});
		btnFinalizar.setBounds(356, 408, 89, 23);
		getContentPane().add(btnFinalizar);				
		
	}
	
	
	protected void btnFinalizarActionPerformed(ActionEvent e) {
		int puntaje = 0;
		for (JRadioButton rb : correctAnswers) {
			if(rb.isSelected()) puntaje++;
		}
		pruebaInformatica.setMark(puntaje);
		int resultado = gestor.calificar(pruebaInformatica, new GestorCandidato().obtener(usuario.getUsername()));
		if(resultado ==1) {
			JOptionPane.showMessageDialog(this, "Su puntaje es de "+puntaje+" respuestas correctas");			
		}else {
			JOptionPane.showMessageDialog(this, "No se pudo calificar la prueba. Contacte el servicio tecnico");
		}
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

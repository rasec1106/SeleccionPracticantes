package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane escritorio;
	
	// Definir nuestros JInternalFrames
	private FrmCandidatos frmCandidatos;
	private FrmConvocatorias frmConvocatorias = new FrmConvocatorias();
	private FrmListadoPruebas frmListadoPruebas = new FrmListadoPruebas();
	private FrmListadoPracticantes frmListadoPracticantes = new FrmListadoPracticantes();
	private FrmListadoConvocatorias frmListadoConvocatorias = new FrmListadoConvocatorias();
	private FrmPrueba frmPrueba = new FrmPrueba();
	private FrmRegistroaConvocatoria frmRegistroaConvocatoria;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal(Usuario user) {
		this();
		usuario = user;
	}
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 616);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuSistema = new JMenu("Sistema");
		menuBar.add(mnuSistema);
		
		JMenuItem mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuSalir(e);
			}
		});
		mnuSistema.add(mnuSalir);
		
		JMenu mnuMantenimientos = new JMenu("Mantenimientos");
		menuBar.add(mnuMantenimientos);
		
		JMenuItem mnuPracticantes = new JMenuItem("Practicantes");
		mnuPracticantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuPracticantes(e);
			}
		});
		mnuMantenimientos.add(mnuPracticantes);
		
		JMenuItem mnuConvocatorias = new JMenuItem("Convocatorias");
		mnuConvocatorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuConvocatorias(e);
			}
		});
		mnuMantenimientos.add(mnuConvocatorias);
		
		JMenuItem mnuPruebas = new JMenuItem("Pruebas de Conocimiento");
		mnuPruebas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuPruebas(e);
			}
		});
		mnuMantenimientos.add(mnuPruebas);
		
		JMenu mnuNewMenu_2 = new JMenu("Reportes");
		menuBar.add(mnuNewMenu_2);
		
		JMenuItem mnuListPracticantes = new JMenuItem("Listado de Practicantes");
		mnuListPracticantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuListPracticantes(e);
			}
		});
		mnuNewMenu_2.add(mnuListPracticantes);
		
		JMenuItem mnuListConvocatorias = new JMenuItem("Listado de Convocatorias");
		mnuListConvocatorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuListConvocatorias(e);
			}
		});
		mnuNewMenu_2.add(mnuListConvocatorias);
		
		JMenuItem mnuListPruebas = new JMenuItem("Listado de Pruebas de Conocimiento");
		mnuListPruebas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMnuListPruebas(e);
			}
		});
		mnuNewMenu_2.add(mnuListPruebas);
		
		JMenu mnNewMenu = new JMenu("Pruebas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnuRendirPrueba = new JMenuItem("Rendir prueba");
		mnuRendirPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuPruebaActionPerformed(e);
			}
		});
		mnNewMenu.add(mnuRendirPrueba);
		
		JMenu mnuRegistro = new JMenu("Registro");
		menuBar.add(mnuRegistro);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrarse a Convocatoria");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem(e);
			}
		});
		mnuRegistro.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(new BorderLayout(0, 0));
		
		this.inicializarVentanas();
	}

	private void inicializarVentanas() {
		escritorio.add(frmConvocatorias);
		escritorio.add(frmListadoPracticantes);
		escritorio.add(frmListadoConvocatorias);
		escritorio.add(frmPrueba);
		
		frmConvocatorias.setVisible(false);
		frmListadoPracticantes.setVisible(false);
		frmListadoConvocatorias.setVisible(false);
		frmPrueba.setVisible(false);
		
	}

	protected void actionPerformedMnuSalir(ActionEvent e) {
		System.exit(DISPOSE_ON_CLOSE);
	}
	protected void actionPerformedMnuPracticantes(ActionEvent e) {
		frmCandidatos = new FrmCandidatos();
		addInternalFrame(frmCandidatos);
	}
	protected void actionPerformedMnuConvocatorias(ActionEvent e) {
		frmConvocatorias.setVisible(true);
	}
	protected void actionPerformedMnuPruebas(ActionEvent e) {
		FrmPruebas frmPruebas = new FrmPruebas(this);
		addInternalFrame(frmPruebas);
	}
	protected void actionPerformedMnuListPracticantes(ActionEvent e) {
		frmListadoPracticantes.setVisible(true);
	}
	protected void actionPerformedMnuListConvocatorias(ActionEvent e) {
		frmListadoConvocatorias.setVisible(true);
	}
	protected void actionPerformedMnuListPruebas(ActionEvent e) {
		frmListadoPruebas = new FrmListadoPruebas();
		addInternalFrame(frmListadoPruebas);
	}
	protected void mnuPruebaActionPerformed(ActionEvent e) {
		frmPrueba.setVisible(true);
	}
	
	public void addInternalFrame(JInternalFrame frame) {
		escritorio.add(frame);
		frame.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		frmRegistroaConvocatoria =  new FrmRegistroaConvocatoria(usuario);
		escritorio.add(frmRegistroaConvocatoria);
		frmRegistroaConvocatoria.setVisible(true);
	}
}

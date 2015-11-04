package capapresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidades.*;
import capanegocio.Controlador;

import java.awt.Color;

import java.util.ArrayList;

public class VentanaJugada extends JFrame {

	private JPanel contentPane;
	private JButton btnMostrarFichas;
	private JLabel lblSeleccionarFicha;
	private JLabel lblNombre;
	private JLabel lblPosicionX;
	private JLabel lblPosicionY;
	private JTextField textnombreficha;
	private JTextField txtPosx;
	private JTextField txtPosy;
	private JButton btnRealizarMov;
	private JTextField txtjugactivo;
	JTextPane txtmuestra = new JTextPane();
	
	Controlador cont = new Controlador();
	private JLabel lblNuevaX;
	private JLabel lblNuevaY;
	private JTextField txtnuevax;
	private JTextField txtnuevay;
	private Partida partida = new Partida();
	boolean permitido;

	
	public VentanaJugada(Partida partidaselect) {
		int jugador;
		partida = partidaselect;
		setTitle("Jugada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// busco jugador activo y valido permito o no sus movimientos//
		jugador = partida.getjugact();
		if (1 == jugador) {
			txtjugactivo.setText((partida.getjugador(1)).getApellido());
			permitido = true;
		}
		else if (2 == jugador) {
			txtjugactivo.setText((partida.getjugador(2)).getApellido());
			permitido = false;
		}
		else{
			JOptionPane.showMessageDialog(null, "A ocurrido un fallo terrible y todo el mundo se destruira en 5 minutos");
		}
		
		
		btnMostrarFichas = new JButton("Mostra posicion fichas");
		btnMostrarFichas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarfichas();
			}
		});
		
		lblSeleccionarFicha = new JLabel("Seleccionar ficha:");
		
		lblNombre = new JLabel("Nombre:");
		
		lblPosicionX = new JLabel("Posicion X:");
		
		lblPosicionY = new JLabel("Posicion Y:");
		
		textnombreficha = new JTextField();
		textnombreficha.setColumns(10);
		
		txtPosx = new JTextField();
		txtPosx.setColumns(10);
		
		txtPosy = new JTextField();
		txtPosy.setColumns(10);
		
		btnRealizarMov = new JButton("Realizar Movimiento");
		btnRealizarMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarmov();
			}
		});
		
		
		
		JLabel lblJugadorActivo = new JLabel("Jugador activo:");
		
		txtjugactivo = new JTextField();
		txtjugactivo.setColumns(10);
		
		lblNuevaX = new JLabel("Nueva X:");
		
		lblNuevaY = new JLabel("Nueva Y:");
		
		txtnuevax = new JTextField();
		txtnuevax.setColumns(10);
		
		txtnuevay = new JTextField();
		txtnuevay.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		
		JLabel lblLine1 = new JLabel("________________________________________________________________________________________");
		lblLine1.setForeground(Color.GRAY);
		
		JLabel lblLine2 = new JLabel("________________________________________________________________________________________");
		lblLine2.setForeground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLine2, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addComponent(lblLine1, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRealizarMov, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(lblSeleccionarFicha)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre)
										.addComponent(lblPosicionX)
										.addComponent(lblPosicionY)
										.addComponent(lblNuevaX)
										.addComponent(lblNuevaY))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtnuevay, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(txtnuevax, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(txtPosy, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(txtPosx, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(textnombreficha, 0, 0, Short.MAX_VALUE))))
							.addGap(56)
							.addComponent(txtmuestra, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnMostrarFichas)
							.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
							.addComponent(lblJugadorActivo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtjugactivo, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSalir, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtjugactivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblJugadorActivo))
						.addComponent(btnMostrarFichas))
					.addGap(13)
					.addComponent(lblLine1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSeleccionarFicha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textnombreficha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPosicionX)
								.addComponent(txtPosx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPosicionY)
								.addComponent(txtPosy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNuevaX)
								.addComponent(txtnuevax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNuevaY)
								.addComponent(txtnuevay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRealizarMov))
						.addComponent(txtmuestra, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblLine2)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnSalir)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	

	public void realizarmov(){
		
		char pieza;
		char posix; 
		char nposix;
		int posiy;
		int nposiy;
		int idpart;
		Usuario jug1;
		Usuario jug2;
		boolean pudo;
		boolean gano;
		
		if (true == permitido) {
			pieza = (char)(textnombreficha.getText()).charAt(0);
			posiy = (Integer.parseInt(txtPosy.getText()));
			nposiy = (Integer.parseInt(txtnuevay.getText()));
			posix = (char)(txtPosx.getText()).charAt(0);
			nposix = (char)(txtnuevax.getText()).charAt(0);
			idpart = partida.getid();
			jug1 = partida.getjugador(1);
			jug2 = partida.getjugador(2);
			pudo = cont.movimientovalido(pieza, posix, posiy, nposix, nposiy, jug1, jug2, idpart);
			if (true == pudo) {
				txtjugactivo.setText((partida.getjugador(2)).getApellido());
				gano =cont.gano(partida.getjugador(2));
				permitido = false;
				if (gano == true) {
					partida.setestado(false);
					cont.actualizarpartida(partida);
				}
			}
						
		}
		else{
			JOptionPane.showMessageDialog(null, "No tiene permitido hacer movimientos hasta que termine el turno del oponente");
		}
		
	}
	
	
	
	public void mostrarfichas(){
		Usuario jug1 = new Usuario();
		jug1 = partida.getjugador(1);
		ArrayList<Pieza> piezas = jug1.getpiezas(); 
		
		
		// usar append para llenar 
		StyledDocument doc = txtmuestra.getStyledDocument();

		//  Define a keyword attribute

		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.BLACK);
		StyleConstants.setBackground(keyWord, Color.WHITE);
		StyleConstants.setBold(keyWord, true);

		//  Add some text
	
	    doc.insertString(0, (partida.getjugador(1).getNombre())+((partida.getjugador(1)).getApellido()) + "\n", null );
	    doc.insertString(0,  "Posicion de las fichas: \n", null );
	    for (int i = 0; i < array.length; i++) {
			
		}
	    doc.insertString(0, ""\n", null );
	    doc.insertString(doc.getLength(), "\nEnd of text", keyWord );
	}
	
	
	public void salir(){
		System.exit(0);
	}
}

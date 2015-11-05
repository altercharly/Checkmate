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
import javax.swing.JTextArea;

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
	
	Controlador cont = new Controlador();
	private JLabel lblNuevaX;
	private JLabel lblNuevaY;
	private JTextField txtnuevax;
	private JTextField txtnuevay;
	private Partida partida = new Partida();
	private JTextArea textMuestra = new JTextArea();
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLine2, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addComponent(lblLine1, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
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
							.addGap(44)
							.addComponent(textMuestra, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMostrarFichas)
							.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
							.addComponent(lblJugadorActivo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtjugactivo, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(textMuestra, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLine2)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
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
		Usuario jug2 = new Usuario();
		String texto = new String();
		// muestro datos y fichas activas del j1
		jug1 = partida.getjugador(1);
		ArrayList<Pieza> piezas = jug1.getpiezas();
		texto = jug1.getApellido() + jug1.getNombre() + "\n";
		for (int i = 0; i < piezas.size(); i++) {
			if ((piezas.get(i)).getestado() == 1) {
				texto = texto + (piezas.get(i)).getname() + " (" + (piezas.get(i)).getposx() + "," +(piezas.get(i)).getposy() + "); " ;  
			}
		texto = texto + " \n \n" ;	
		}
		// muestro datos y fichas activad del j2
		jug2 = partida.getjugador(2);
		ArrayList<Pieza> piezas2 = jug2.getpiezas();
		texto = jug2.getApellido() + jug2.getNombre() + "\n";
		for (int i = 0; i < piezas2.size(); i++) {
			if ((piezas2.get(i)).getestado() == 1) {
				texto = texto + (piezas2.get(i)).getname() + " (" + (piezas2.get(i)).getposx() + "," +(piezas2.get(i)).getposy() + "); " ;  
			}
		texto = texto + " \n" ;	
		}
	
	}
	
	
	public void salir(){
		System.exit(0);
	}
}

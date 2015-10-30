package capapresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidades.*;
import capanegocio.Controlador;

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

	
	public VentanaJugada(Partida partidaselect) {
		setTitle("Jugada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMostrarFichas = new JButton("Mostra posicion fichas");
		
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
		
		JTextPane textPane = new JTextPane();
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRealizarMov, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
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
										.addComponent(txtnuevay, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addComponent(txtnuevax, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addComponent(txtPosy, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addComponent(txtPosx, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
										.addComponent(textnombreficha, 0, 0, Short.MAX_VALUE))))
							.addGap(56)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
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
					.addGap(33)
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
							.addComponent(btnRealizarMov)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(btnSalir))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
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
		posiy = (Integer.parseInt(txtPosy.getText()));
		nposiy = (Integer.parseInt(txtnuevay.getText()));
		cont.movimientovalido(pieza, posix, posiy, nposix, nposiy, jug1, jug2, idpart);
		
		// falta seguir pasando datos a las variables
		
	}
}

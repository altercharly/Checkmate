package capapresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capanegocio.*;
import entidades.*;

import java.util.ArrayList;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import entidades.*;
import capanegocio.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class Ventana extends JFrame {
	Usuario u = new Usuario();
	Controlador cont = new Controlador();
	String message; 
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDniCont;
	private JList<Partida> listapart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setTitle("Menu Ajedrez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni :");
		lblDni.setBounds(10, 11, 22, 23);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(54, 12, 100, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 41, 44, 23);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setBounds(164, 41, 44, 23);
		contentPane.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(54, 43, 100, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(207, 42, 100, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar Usuario");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				u=buscarusuario((Integer.parseInt(txtDni.getText())));
				
				if (u==null)
				{
					JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				}
				else 
				{
					txtNombre.setText(u.getNombre());
				txtApellido.setText(u.getApellido());
				}
			}
		});
		btnBuscar.setBounds(164, 11, 143, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Nuevo Usuario");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crearusuario((Integer.parseInt(txtDni.getText())),txtNombre.getText(),txtApellido.getText());
			}
		});
		btnAgregar.setBounds(351, 11, 144, 23);
		contentPane.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar Usuario");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarusuario((Integer.parseInt(txtDni.getText())));
			}
		});
		btnBorrar.setBounds(351, 41, 144, 23);
		contentPane.add(btnBorrar);
		
		listapart = new JList<Partida>();
		listapart.setBounds(10, 114, 297, 192);
		contentPane.add(listapart);
		
		JButton btnbuscarpart = new JButton("Buscar Partida");
		btnbuscarpart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listapart.setModel(buscarpartida(Integer.parseInt(txtDni.getText())));;
			}
		});
		btnbuscarpart.setBounds(352, 111, 143, 23);
		contentPane.add(btnbuscarpart);
		
		JButton btnnuevapart = new JButton("Nueva Partida");
		btnnuevapart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevapartida((Integer.parseInt(txtDniCont.getText())));
			}
		});
		btnnuevapart.setBounds(351, 145, 144, 23);
		contentPane.add(btnnuevapart);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnsalir.setBounds(351, 316, 144, 23);
		contentPane.add(btnsalir);
		
		JLabel lblDniCont = new JLabel("Dni:");
		lblDniCont.setBounds(351, 206, 22, 14);
		contentPane.add(lblDniCont);
		
		txtDniCont = new JTextField();
		txtDniCont.setBounds(371, 203, 124, 20);
		contentPane.add(txtDniCont);
		txtDniCont.setColumns(10);
		
		JLabel lblContrincante = new JLabel("Contrincante");
		lblContrincante.setBounds(371, 179, 82, 14);
		contentPane.add(lblContrincante);
		
		JLabel lblLine = new JLabel("________________________________________________________________________________");
		lblLine.setForeground(Color.GRAY);
		lblLine.setBounds(10, 85, 485, 14);
		contentPane.add(lblLine);
		
		JButton btnjugar = new JButton("Jugar");
		btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugar();
			}
		});
		btnjugar.setBounds(8, 317, 146, 22);
		contentPane.add(btnjugar);
	}
	
	
	
	
	public Usuario buscarusuario(int dni){
		u = cont.buscarusuario(dni);
		return u;
	}
	
	
	
	
	public void crearusuario(int dni, String nombre, String apellido){
		u.setdni(dni);
		u.setNombre(nombre);
		u.setApellido(apellido);
		message = cont.addUsuario(dni, nombre, apellido);
		JOptionPane.showMessageDialog(null, message);
		limpiarCampos();
		
	}
	
	
	
	
	public void borrarusuario(int dni){
		message = cont.deleteUsuario(dni);
		limpiarCampos();
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	
	
	public DefaultListModel<Partida> buscarpartida(int dni1){
		ArrayList<Partida> p = new ArrayList<Partida>();
		p =cont.buscarpartida(dni1);
		if (p!=null)
		
		{// modelos para mostrar en el jlist//
		DefaultListModel<Partida> model = new DefaultListModel<>();
		for (int i = 0; i < p.size() + 1; i++) {
			model.addElement(p.get(i));
		}
		return model;
		}
		else {JOptionPane.showMessageDialog(null, "No hay partidas cargadas");
			return null;
		}
	}
	
	public void nuevapartida(int dni2){
		Partida part = new Partida();
		Usuario contrin = new Usuario();
		contrin = cont.buscarusuario(dni2); 
		// generar la ventana de partida//
		part.iniciarpartida(u,contrin);
		VentanaJugada jugada = new VentanaJugada(part);
		jugada.setVisible(true);
		cont.guardarpartida(part);
	}
	
	
	
	public void jugar(){
		Partida partidaselect = new Partida();
		partidaselect = listapart.getSelectedValue();
		//genero la ventana partida//
		VentanaJugada jugada = new VentanaJugada(partidaselect);
		jugada.setVisible(true);
		
	}
	
	public void limpiarCampos()
	{
		txtNombre.setText("");
		txtApellido.setText("");
	}
	
	public void salir(){
		System.exit(0);
	}
}

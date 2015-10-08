package capapresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capanegocio.*;
import entidades.*;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		btnBuscar.setBounds(164, 11, 143, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Nuevo Usuario");
		btnAgregar.setBounds(351, 11, 144, 23);
		contentPane.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar Usuario");
		btnBorrar.setBounds(351, 41, 144, 23);
		contentPane.add(btnBorrar);
		
		JList list = new JList();
		list.setBounds(10, 114, 297, 237);
		contentPane.add(list);
		
		JButton btnbuscarpart = new JButton("Buscar Partida");
		btnbuscarpart.setBounds(352, 111, 143, 23);
		contentPane.add(btnbuscarpart);
		
		JButton btnnuevapart = new JButton("Nueva Partida");
		btnnuevapart.setBounds(351, 145, 144, 23);
		contentPane.add(btnnuevapart);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.setBounds(351, 316, 144, 23);
		contentPane.add(btnsalir);
	}
}

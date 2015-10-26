package entidades;

import java.util.ArrayList;

public class Usuario {
	
	String nombre;
	String apellido;
	int id;
	int dni;
	ArrayList<Pieza> piezas;
	
    public Usuario(){
		
	}
    
    
	public Usuario(int dni, String nombre, String apellido){
		setdni(dni);
		setNombre(nombre);
		setApellido(apellido);
		
	}
	
	
	
	public void setdni(int dni){
		this.dni=dni;
	}
	
	
	
	public int getdni(){
		return dni;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getApellido() {
		return apellido;
	}
	
	
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	public void setId(int id){
		this.id = id;
	}
	
	
	
	public int getId(){
		return id;
	}
	
	
	
	public void setpiezas(ArrayList<Pieza> piezas){
		this.piezas = piezas;
	}
	
	
	
	public ArrayList<Pieza> getpiezas(){
		return this.piezas;
	}

	
	
}

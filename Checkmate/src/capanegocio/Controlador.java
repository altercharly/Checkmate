package capanegocio;

import java.util.ArrayList;

import capadata.*;
import entidades.*;


public class Controlador {
	Catusuario catu = new Catusuario();
	Catalogopartidas cp = new Catalogopartidas();
	
	public Usuario buscarusuario(int dni){
		return catu.buscarusuario(dni);
	}
	public String addUsuario(int dni, String nombre, String apellido){
		Usuario u = new Usuario();
		String message = "ERROR Charly";
		u = buscarusuario(dni);
		if (u == null){
			catu.addUsuario(dni, nombre, apellido);
			return (message = "Guardado con exito");}
		return message;
		}
	
	
	public String deletePersona(int dni){
		return catu.deleteUsuario(dni);
	}
	
	public ArrayList<Integer> buscarOponentes(int dni)
	{
		ArrayList<Integer> listaOponentes = cp.buscarOponente(dni);
		return(listaOponentes);
	}
	public String movimientovalido(char pieza, char posix, int posiy,char nposix, int nposiy, Usuario jug1, Usuario jug2){
		String message = "Movimiento invalido";
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		pieza1 = jug1.getpiezas();
		for (int i = 0; i < 16; i++) {
			
		}
		
		return message;
	}
	
}

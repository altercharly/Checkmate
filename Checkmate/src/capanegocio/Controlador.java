package capanegocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import capadata.*;
import entidades.*;


public class Controlador {
	
	Catusuario catu = new Catusuario();
	Catalogopartidas cpa = new Catalogopartidas();
	Catpiezas cp = new Catpiezas();
	
	
	
	public Usuario buscarusuario(int dni){
		return catu.buscarusuario(dni);
	}
	
	
	
	public String addUsuario(int dni, String nombre, String apellido){
		Usuario u = new Usuario();
		String message = "ERROR";
		u = buscarusuario(dni);
		if (u == null){
			catu.addUsuario(dni, nombre, apellido);
			return (message = "Guardado con exito");}
		return message;
		}
	
	
	
	public String deleteUsuario(int dni){
		return catu.deleteUsuario(dni);
	}
	
	
	
	
	public boolean movimientovalido(char pieza, char posix, int posiy,char nposix, int nposiy, Usuario jug1, Usuario jug2,int idpart){
		
		String message = "Movimiento invalido";
		boolean puede;
		boolean puedepeon;
		char nombre;
		int posy;
		char posx;
		char color;
		int estado;
		int id1;
		int id2;
		
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		pieza1 = jug1.getpiezas();
		pieza2 = jug2.getpiezas();
		id1 = jug1.getId();
		id2 = jug2.getId();
		puede = false;
		for (int i = 0; i < 16; i++) {
			nombre = pieza1.get(i).getname();
			posx = pieza1.get(i).getposx();
			posy = pieza1.get(i).getposy();
			if((nombre == pieza)&&(posiy == posy)&&(posix==posx)){
				for(int j=0; j < 6; i++){
					switch(i){
						case 0:
							if ( 'a' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Alfil alf = new Alfil(nombre, color, posix, posiy, estado);
								puede = alf.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									alf.setposx(nposix);
									alf.setposy(nposiy);
									pieza1.set(i,alf);
									cp.guardarpieza(pieza1,pieza2, id1, id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							}
							break;
						case 1:
							if ( 'c' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Caballo cab = new Caballo(nombre, color, posix, posiy, estado);
								puede = cab.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									cab.setposx(nposix);
									cab.setposy(nposiy);
									pieza1.set(i,cab);
									cp.guardarpieza(pieza1,pieza2,id1, id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							}
							break;
						case 2:
							if ( 'd' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Reina reina = new Reina(nombre, color, posix, posiy, estado);
								puede = reina.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									reina.setposx(nposix);
									reina.setposy(nposiy);
									pieza1.set(i,reina);
									cp.guardarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 3:
							if ( 'r' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Rey rey = new Rey(nombre, color, posix, posiy, estado);
								puede = rey.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									rey.setposx(nposix);
									rey.setposy(nposiy);
									pieza1.set(i,rey);
									cp.guardarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 4:
							if ( 't' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Torre torr = new Torre(nombre, color, posix, posiy, estado);
								puede = torr.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									torr.setposx(nposix);
									torr.setposy(nposiy);
									pieza1.set(i,torr);
									cp.guardarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 5:
							if ( 'p' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Peon peon = new Peon(nombre, color, posix, posiy, estado);
								puedepeon = peon.movPerm(nposiy, nposix);
								if (true == puedepeon){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
										else if(nposix != posix){
											message ="Movimiento invalido";
											JOptionPane.showMessageDialog(null, message);
											puede = false;
											break;
										}
									}
									peon.setposx(nposix);
									peon.setposy(nposiy);
									pieza1.set(i,peon);
									cp.guardarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;					
						}
				}
			}
		}
		return puede;
	}
	
	
	
	public void nuevapartida(Usuario jug1,Usuario jug2){
		Partida partn = new Partida();
		partn.iniciarpartida(jug1, jug2);
	}
	
	
	
	//public void cargarpartida(ArrayList<Pieza> piezas1, Usuario jug1, ArrayList<Pieza> piezas2, Usuario jug2, int idpart ){
		//Partida partn = new Partida();
		//partn.cargarpartida(piezas1, jug1, piezas2, jug2,idpart);
	//}
	
	
	
	public ArrayList<Partida> buscarpartida(int dni1){
		ArrayList<Partida> p = new ArrayList<Partida> ();
		p =	cpa.buscarpartida(dni1);
		return p;
	}
	
	
	
	
	public boolean gano(Usuario jug2){
		Usuario jug = new Usuario();
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		int esta;
		boolean gana;
		jug = jug2;
		gana = false;
		piezas = jug.getpiezas();
		for (Pieza p : piezas){
			if ((p.getestado() == 0) && (p.getname()== 'r')) {
				JOptionPane.showMessageDialog(null, "GANASTE");
				gana = true;
			}
		}
		return gana;
	}



	public void guardarpartida(Partida partida) {
		Partida part = new Partida();
		part = partida;
		cpa.guardarpartida(part);
		
	}



	public void actualizarpartida(Partida partida) {
		Partida part = new Partida();
		part = partida;
		cpa.actualizarpartida(part);
		
	}

}

package entidades;

import java.util.ArrayList;


public class Partida {
	
	int id;
	Usuario jugador1;
	Usuario jugador2;
	boolean estado;  // true activa y false terminada
	int jugact;  // 1 para jug 1 y 2 para jug 2
	
	
	//public void cargarpartida(ArrayList<Pieza> piezas1, Usuario jug1, ArrayList<Pieza> piezas2, Usuario jug2,int idpart ){
		//jugador1 = jug1;
		//jugador1.setpiezas(piezas1);
		//jugador2 = jug2;
		//jugador2.setpiezas(piezas2);
		//id = idpart;
	//}
	
	
	
	public void iniciarpartida(Usuario jug1, Usuario jug2){
		
		jugador1 = jug1;
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		char nombre;
		char colorin;
		char posix;
		int posiy;
		int est;
		
		jugact = 1;
		nombre = 't';
		colorin = 'b';
		posix = 'a';
		posiy = 1;
		est = 1;
		Torre torre1 = new Torre(nombre, colorin, posix, posiy, est);
		pieza1.add(torre1);
		nombre = 'c';
		posix ='b';
		Caballo caballo1 = new Caballo(nombre, colorin, posix, posiy, est);
		pieza1.add(caballo1);
		nombre = 'a';
		posix = 'c';
		Alfil alfil1 = new Alfil(nombre, colorin, posix, posiy, est);
		pieza1.add(alfil1);
		nombre = 'r';
		posix = 'd';
		Rey rey = new Rey(nombre, colorin, posix, posiy, est);
		pieza1.add(rey);
		nombre = 'd';
		posix = 'e';
		Reina reina = new Reina(nombre, colorin, posix, posiy, est);
		pieza1.add(reina);
		nombre ='a';
		posix = 'f';
		Alfil alfil2 = new Alfil(nombre, colorin, posix, posiy, est);
		pieza1.add(alfil2);
		nombre = 'c';
		posix = 'g';
		Caballo caballo2 = new Caballo(nombre, colorin, posix, posiy, est);
		pieza1.add(caballo2);
		nombre = 't';
		posix = 'h';
		Torre torre2 = new Torre(nombre, colorin, posix, posiy, est);
		pieza1.add(torre2);
		nombre = 'p';
		posiy = 2;
		posix = 'a';
		for (int i = 0; i < 8; i++) {
			Peon peon = new Peon(nombre, colorin, posix, posiy, est);
			pieza1.add(peon);
			posix ++;
		}
		
		
		jugador2 = jug2;
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		nombre = 't';
		colorin = 'n';
		posix = 'a';
		posiy = 8;
		est = 1;
		Torre torre3 = new Torre(nombre, colorin, posix, posiy, est);
		pieza2.add(torre3);
		nombre = 'c';
		posix ='b';
		Caballo caballo3 = new Caballo(nombre, colorin, posix, posiy, est);
		pieza2.add(caballo3);
		nombre = 'a';
		posix = 'c';
		Alfil alfil3 = new Alfil(nombre, colorin, posix, posiy, est);
		pieza2.add(alfil3);
		nombre = 'r';
		posix = 'd';
		Rey rey1 = new Rey(nombre, colorin, posix, posiy, est);
		pieza2.add(rey1);
		nombre = 'd';
		posix = 'e';
		Reina reina1 = new Reina(nombre, colorin, posix, posiy, est);
		pieza2.add(reina1);
		nombre ='a';
		posix = 'f';
		Alfil alfil4 = new Alfil(nombre, colorin, posix, posiy, est);
		pieza2.add(alfil4);
		nombre = 'c';
		posix = 'g';
		Caballo caballo4 = new Caballo(nombre, colorin, posix, posiy, est);
		pieza2.add(caballo4);
		nombre = 't';
		posix = 'h';
		Torre torre4 = new Torre(nombre, colorin, posix, posiy, est);
		pieza2.add(torre4);
		nombre = 'p';
		posiy = 7;
		posix = 'a';
		for (int i = 0; i < 8; i++) {
			Peon peon = new Peon(nombre, colorin, posix, posiy, est);
			pieza2.add(peon);
			posix ++;
		}
	}
	
	
	
	public int getid(){
		return this.id;
	}
	
	
	public void setid(int iD){
		this.id = iD;
	}
	
	
	public void setestado(boolean est){
		this.estado = est;
	}
	
	
	public boolean getestado(){
		return this.estado;
	}
	
	
	public void setjugact(int activo){
		this.jugact = activo;
	}
	
	
	public int getjugact(){
		return this.jugact;
	}
	
	
	
	public Usuario getjugador(int jug){
		if (1 == jug) {
			return jugador1;
		}
		else if (2 == jug){
			return jugador2;
		}
		else 
			return null;
		
	}
	
	
}

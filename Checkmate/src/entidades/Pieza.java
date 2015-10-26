package entidades;

public abstract class Pieza {
	
	char name;   // una sola letra para representar la pieza, P para peon, A par alfil,etc //
	char color;  // b para las blanca, n para las negras//
	char posx;
	int posy;
	int estado; // 1 si esta en el tablero o 0 si esta en el cementerio//
	
	
	public void setname(char name){
		this.name = name;
	}
	
	
	
	public char getname(){
		return name;
	}
	
	
	
	public void setcolor(char color){
		this.color = color;
	}
	
	
	
	public char getcolor(){
		return color;
	}
	
	
	
	public void setposx(char posix){
		this.posx = posix;
	}
	
	
	
	public char getposx(){
		return posx;
	}
	
	
	
	public void setposy(int posiy){
		this.posy = posiy;
	}
	
	
	
	public int getposy(){
		return posy;
	}
	
	
	
	public void setestado(int estado){
		this.estado = estado;
	}
	
	
	
	public int getestado(){
		return estado;
	}

}

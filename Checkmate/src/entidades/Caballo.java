package entidades;

public class Caballo extends Pieza {
	
	public Caballo(char nombre, char colorin, char posix, int posiy, int est){
		name = nombre;
		color = colorin;
		posx = posix;
		posy = posiy;
		estado = est;
	}
	
	
	
	public Boolean movPerm(int x, char y){
		Boolean resultado;
		char xpos;
		int ypos;
		
		resultado = false;
		xpos= this.getposx();
		ypos= this.getposy();
		for(int i=0; i < 3; i++){
			switch(i){
				case 0:
					if(x == this.getposx() +2){
						if(y== this.getposy() +1){
							resultado = true;
							return resultado;
						}
						else if( y == this.getposy() -1){
							resultado = true;
							return resultado;
						}
					}
					break;
				case 1:
					if(x == this.getposx() -2){
						if(y== this.getposy() +1){
							resultado = true;
							return resultado;
						}
						else if( y == this.getposy() -1){
							resultado = true;
							return resultado;
						}
					}
					break;
				case 2:
					if(y == this.getposy() +2){
						if(x== this.getposx() +1){
							resultado = true;
							return resultado;
						}
						else if( x == this.getposx() -1){
							resultado = true;
							return resultado;
						}
					}
					break;
				case 3:
					if(y == this.getposy() -2){
						if(x== this.getposx() +1){
							resultado = true;
							return resultado;
						}
						else if( x == this.getposx() -1){
							resultado = true;
							return resultado;
						}
					}
					break;
			}
		
		}
	return resultado;
	}
	
	
}

package entidades;

public class Rey extends Pieza {
	
	public Rey(char nombre, char colorin, char posix, int posiy, int est){
		name = nombre;
		color = colorin;
		posx = posix;
		posy = posiy;
		estado = est;
	}
	
	
	
	public Boolean movPerm(int x, char y){
		Boolean resultado;
		
		resultado = false;
		for(int i=0; i < 8; i++){
			switch(i){
				case 0:
					if (( x == this.posx + 1) && (y == this.posy ++)){
						resultado = true;
						return resultado;
					}
					break;
				case 1:
					if (( x == this.posx + 1) && (y == this.posy --)){
						resultado = true;
						return resultado;
					}
					break;
				case 2:
					if (( x == this.posx - 1) && (y == this.posy ++)){
						resultado = true;
						return resultado;
					};
					break;
				case 3:
					if (( x == this.posx - 1) && (y == this.posy --)){
						resultado = true;
						return resultado;
					};
					break;
				case 4:
					if (( x == this.posx) && (y == this.posy ++)){
						resultado = true;
						return resultado;
					};
					break;
				case 5:
					if (( x == this.posx - 1) && (y == this.posy)){
						resultado = true;
						return resultado;
					};
					break;
				case 6:
					if (( x == this.posx + 1) && (y == this.posy)){
						resultado = true;
						return resultado;
					};
					break;
				case 7:
					if (( x == this.posx) && (y == this.posy --)){
						resultado = true;
						return resultado;
					};
					break;					
				}
		}
	return resultado;
	}
	
	
	
}

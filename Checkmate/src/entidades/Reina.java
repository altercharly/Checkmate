package entidades;

public class Reina extends Pieza {
	
	public Reina(char nombre, char colorin, char posix, int posiy, int est){
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
		for(int i=0; i < 5; i++){
			switch(i){
				case 0:
					for (int j = 0; j < 7; j++) {
						xpos ++;
						ypos ++;
						if((x == xpos) && (y == ypos)){
							resultado = true;
							return resultado;
							}
						}
					break;
				case 1:
					for (int j = 0; j < 7; j++) {
						xpos ++;
						ypos --;
						if((x == xpos) && (y == ypos)){
							resultado = true;
							return resultado;
							}
						}	
					break;
				case 2:
					for (int j = 0; j < 7; j++) {
						xpos --;
						ypos ++;
						if((x == xpos) && (y == ypos)){
							resultado = true;
							}
						}
					break;
				case 3:
					for (int j = 0; j < 7; j++) {
						xpos --;
						ypos --;
						if((x == xpos) && (y == ypos)){
							resultado = true;
							return resultado;
							}
						}	
					break;
				case 4:
					if( x == this.getposx()){
						resultado = true;
						return resultado;
					}
					break;
				case 5:
					if( y == this.getposy()){
						resultado = true;
						return resultado;
					}
					break;
				}
			}
		return resultado;	
	}
	
	
	
}




package entidades;

public class Torre extends Pieza {
	
	public Torre(char nombre, char colorin, char posix, int posiy, int est){
		name = nombre;
		color = colorin;
		posx = posix;
		posy = posiy;
		estado = est;
	}
	
	
	
	public Boolean movPerm(int x, char y){
		Boolean resultado;
		
		resultado = false;
		if( x == this.getposx()){
			resultado = true;
		}
		else if( y == this.getposy()){
			resultado = true;
		}
		return resultado;
	}
	
	
	
}

package entidades;

public class Torre extends Pieza {
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

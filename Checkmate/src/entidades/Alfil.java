package entidades;

public class Alfil extends Pieza {
	public Boolean movPerm(int x, char y){
		Boolean resultado;
		resultado = false;
		if( (x != this.getposx()) && ( y != this.getposy())){
			resultado = true;
		}
		return resultado;
	}
}

//terminar de ajustar validacion
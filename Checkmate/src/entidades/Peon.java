package entidades;

public class Peon extends Pieza {
	
	public int movPermix(){
		int pestado;
		int pposy;
		char pposx;
		int movper;
		char pcolor;
		if (this.color == 'w'){
			for (int i = 0; i < array.length; i++) {   //modificar por nombre de arreglo de jugadas
				// correr arreglo y obtener posicion ficha
				pestado = array.getstado();
				if (1 == pestado){
					pposy = array.getposy();
					pposx = array.getposx();
					pcolor = array.getcolor();
					if(this.color != pcolor){
						movper= this.posx+1;
					}
					else{
						movper = this.posx;
					}
				}
			}
			
			return movper;}             //revisar bien, parece que me equivoque en algo
		else{
			movper= this.posy - 1;
		}
	return movper;
	}
	public int movPermy(){
		int movPermy;
		int movPermy2;
		movPermy = this.posx;
		
		return movPermy;
	}

}

// cambiar todo por un boolean q devuelva T or F
package capanegocio;

import capadata.*;
import entidades.*;


public class Controlado {
	Catusuario catu = new Catusuario();
	
	public Usuario buscarusuario(int dni){
		return catu.buscarusuario(dni);
	}
	
	
}

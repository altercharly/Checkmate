package capadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;



import entidades.Alfil;
import entidades.Caballo;
import entidades.Peon;
import entidades.Pieza;
import entidades.Reina;
import entidades.Rey;
import entidades.Torre;
import entidades.Usuario;



public class Catpiezas {
	
	
	public void guardarpieza(ArrayList<Pieza> pie1, ArrayList<Pieza> pie2, int id1, int id2, int idpart){
		
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		pieza1 = pie1;
		pieza2 = pie2;
		char nombre;
		int posy;
		char posx;
		char color;
		int estado;
		String sql;
		
		PreparedStatement sentencia=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		
		for (int i = 0; i < 16; i++) {
			nombre = pieza1.get(i).getname();
			posx = pieza1.get(i).getposx();
			posy = pieza1.get(i).getposy();
			color = pieza1.get(i).getcolor();
			estado = pieza1.get(i).getestado();
			
			
			sql = "UPDATE `ajedrez`.`piezas` SET `nombre` = ?, `posx` = ?, `posy` = ?, `color`= ?, `estado` = ? WHERE `id` = ? AND `idpartida` = ? ;";
			try {
				sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setInt(1,nombre);
				sentencia.setInt(2, posx);
				sentencia.setInt(3,posy);
				sentencia.setInt(4, color);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, id1);
				sentencia.setInt(7, idpart);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int j = 0; i < 16; i++) {
			nombre = pieza2.get(j).getname();
			posx = pieza2.get(j).getposx();
			posy = pieza2.get(j).getposy();
			color = pieza2.get(j).getcolor();
			estado = pieza2.get(j).getestado();
				
												
			sql = "UPDATE `ajedrez`.`piezas` SET `nombre` = ?, `posx` = ?, `posy` = ?, `color`= ?, `estado` = ? WHERE `id` = ? AND `idpartida` = ? ;";
			try {
				sentencia = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setInt(1,nombre);
				sentencia.setInt(2, posx);
				sentencia.setInt(3,posy);
				sentencia.setInt(4, color);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, id2);
				sentencia.setInt(7, idpart);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			
				}
			}
		}
	}
	
	
	
	
}


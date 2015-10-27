package capadata;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;

import entidades.Pieza;
import entidades.Usuario;
import entidades.Partida;


public class Catalogopartidas {
	
	
	public ArrayList<Integer> buscarOponente(int dni){
		
		ArrayList<Integer> oponentes = new ArrayList<Integer>();
		
		String sql="select dni from usuario inner join partidas on partidas.dni = usuario.dni where `dni`= ? ;";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, dni);
			rs= sentencia.executeQuery();
			
			while (rs.next())
			{			
				oponentes.add(rs.next());
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}	
		return(oponentes);
	}

	public 	ArrayList<Partida> buscarpartida(int dni1){
		ArrayList<Partida> p = new ArrayList<Partida>();
		Partida part = new Partida();
		String sql="select * from partida  where `dnijug1`= ?  ;";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, dni1);
			rs= sentencia.executeQuery();
			while (rs.next()){
				part.setid(rs.getInt(1));
				p.add(part);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
		return p;
	}
	
	
	
}

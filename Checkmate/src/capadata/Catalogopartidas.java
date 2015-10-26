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

	public 	Partida buscarpartida(int dni1, int dni2){
		Partida p = new Partida();
		String sql="select * from partida  where `dnijug1`= ? and `dnijug2`= ?  ;";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, dni1);
			sentencia.setInt(2, dni2);
			rs= sentencia.executeQuery();
			p.setid(rs.getInt(1));
			
			
			
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

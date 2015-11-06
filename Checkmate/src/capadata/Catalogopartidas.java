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
	
	

	public 	ArrayList<Partida> buscarpartida(int dni1){
		ArrayList<Partida> p = new ArrayList<Partida>();
		p=null;
		Partida part = new Partida();
		String sql="select * from partida  where turno= ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, dni1);
			rs= sentencia.executeQuery();
			while (rs !=null && rs.next()){
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
	
	
	public Partida guardarPartida (Partida partida)
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
				
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into partidas(estado,turno,dni1,dni2) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
				   );
			stmt.setBoolean(1, partida.getestado());
			stmt.setInt(2, partida.getjugact());
			stmt.setInt(3, partida.getjugador(1).getdni());
			stmt.setInt(4, partida.getjugador(2).getdni());
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				partida.setid(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
		return partida;
	}
	

	

public void actualizarPartida(Partida partida)
{
	ResultSet rs=null;
	PreparedStatement stmt=null;
			
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
				"update partidas set estado = ? where idpartida = ?");
		stmt.setBoolean(1, partida.getestado());
		stmt.setInt(2, partida.getid());
		
		stmt.executeUpdate();

				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		
		try {
			if(rs!=null ) rs.close();
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FactoryConexion.getInstancia().releaseConn();
	}

}
}


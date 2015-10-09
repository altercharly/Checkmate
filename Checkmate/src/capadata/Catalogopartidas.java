package capadata;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;

import entidades.Pieza;
import entidades.Usuario;


public class Catalogopartidas {
	public ArrayList<Integer> buscarOponente(int dni)
	{
		ArrayList<Integer> oponentes = new ArrayList<Integer>();
		
		String sql="select dni from usuario innerjoin partidas on partidas.dni = usuario.dni where `dni`= ? ;";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = Conexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, dni);
			rs= sentencia.execute();
			
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
				Conexion.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}	
		return(oponentes);
	}

	public void guardarpiezas(ArrayList<Pieza> pieza1, ArrayList<Pieza> pieza2) {
		// TODO Auto-generated method stub
		
	}

}

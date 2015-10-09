package capadata;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import entidades.Usuario;


public class Catalogopartidas {
	public ArrayList<Integer> buscarOponente(int dni)
	{
		ArrayList<Integer> oponentes = new ArrayList<Integer>();
		
		String sql="select blanco, negro from partida where blanco = ? or negro = ?;";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = Conexion.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, dni);
			sentencia.setInt(2, dni);
			rs= sentencia.executeQuery();
			
			while (rs.next())
			{			
				int blanco = rs.getInt("blanco"), negro = rs.getInt("negro");
				if(blanco == dni)
					oponentes.add(negro);
				else
					oponentes.add(blanco);
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

}

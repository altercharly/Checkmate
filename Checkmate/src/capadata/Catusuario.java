package capadata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.*;



public class Catusuario {
	
	
	public Usuario buscarusuario(int dni){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Usuario u=null;
		
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idUsuario, dni, nombre, apellido from usuario where dni = ?"
					);
			stmt.setInt(1, dni);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				u =new Usuario();
				u.setId(rs.getInt("idUsuario"));
				u.setdni(rs.getInt("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return u;
	}
	
	
	
	
	public Usuario addUsuario(int dni,String nombre, String apellido){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Usuario u= new Usuario(dni,nombre,apellido);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into usuario (dni, nombre, apellido) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				u.setId(rs.getInt(1));
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
		return u;
	}
	
	
	
	public String deleteUsuario(int dni){
		String message = "Usuario no encontrado";
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Usuario u=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"DELETE from usuario where dni = ?"
					);
			stmt.setInt(1, dni);
			stmt.execute();
			message="Usuario borrado con exito";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
	
		return message;	
	}
	
	
	
}

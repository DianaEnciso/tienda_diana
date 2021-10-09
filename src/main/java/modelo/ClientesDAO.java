package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controller.Conexion;


public class ClientesDAO 

{
	
	Conexion con= new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ClientesDTO clientes;
	
	
	//INSERTAR CLIENTE
	
	public boolean insertaruncliente(ClientesDTO cli)
	{
		int x;
		boolean dato=false;
		
		try 
		{
			ps=cnn.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?)");
			ps.setInt(1, cli.getCedula_clien());
			ps.setString(4, cli.getNombre_clien());
			ps.setString(2, cli.getDireccion__clien());
			ps.setString(3, cli.getEmail_clien());
			ps.setString(5, cli.getTelef_clien());
			x=ps.executeUpdate();
			
			if(x>0)
			{
				dato=true;
			}
			
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Cliente ya registrado");
			e.printStackTrace();
		}
		return dato;
		
	}
	
	//CONSULTAR UN CLIENTE
	
	public ClientesDTO consultarunCliente(ClientesDTO cli)
	{
		try 
		{
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cli.getCedula_clien());
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				clientes=new ClientesDTO (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			
			}
			
			
			
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al consultar el cliente " + e);
			e.printStackTrace();
		}
		
		return clientes;
		
	}
	
	
	//ELIMINAR CLIENTE
	
	public int eliminarCliente(ClientesDTO cli)
	{
		int x=0;
		
		try 
		{
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cli.getCedula_clien());
			x=ps.executeUpdate();
		
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al eliminar el cliente " + e);
			e.printStackTrace();
		}
		
		return x;	
			
	}
	
	//ACTUALIZAR CLIENTE
	
	public boolean actualizar(ClientesDTO cli)
	{
		boolean dat=false;
		int x;
		
		try 
		{
		ps=cnn.prepareStatement("UPDATE clientes SET nombre_cliente=?, direccion_cliente=?, email_cliente=?, telefono_cliente=? WHERE cedula_cliente=?");
		ps.setString(1, cli.getNombre_clien());
		ps.setString(2, cli.getDireccion__clien());
		ps.setString(3, cli.getEmail_clien());
		ps.setString(4, cli.getTelef_clien());
		ps.setInt(5, cli.getCedula_clien());
		
		x=ps.executeUpdate();
			
		if(x>0)
		{
			dat=true;
		}
		
		}catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return dat;
	}
	
	
	
	public ArrayList<ClientesDTO> consultageneral()
	{
		
		JOptionPane.showMessageDialog(null, "ingreso al array");
		ArrayList<ClientesDTO> lista=new ArrayList<>();
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
			
			while (rs.next())
			{
				
				clientes=new ClientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(clientes);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
}

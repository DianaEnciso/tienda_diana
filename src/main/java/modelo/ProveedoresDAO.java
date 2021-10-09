package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.Conexion;


public class ProveedoresDAO 

{
	Conexion con= new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ProveedoresDTO proveedor;
	
	
	//INSERTAR PROVEEDOR
	
	public boolean insertarproveedor(ProveedoresDTO prove)
	{
		int x;
		boolean dato=false;
		
		try 
		{
			ps=cnn.prepareStatement("INSERT INTO proveedores VALUES (?,?,?,?,?)");
			ps.setInt(1, prove.getNit());
			ps.setString(4, prove.getName());
			ps.setString(2, prove.getCity());
			ps.setString(3, prove.getAddress());
			ps.setString(5, prove.getTele());
			x=ps.executeUpdate();
			
			if(x>0) 
			{
				dato=true;
			}
			
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Proveedor ya registrado");
			e.printStackTrace();
		}
		return dato;
		
	}
	
	
	
	//CONSULTAR PROVEEDOR
	
	public ProveedoresDTO consultarproveedor(ProveedoresDTO prove)
	{
		
		try 
		{
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, prove.getNit());
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				proveedor= new ProveedoresDTO (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			
			
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al consultar el proveedor" + e);
			e.printStackTrace();
		}
		
		return proveedor;
		
	}
	
	
	
	//ACTUALIZAR PROVEEDOR
	
	public boolean actualizar(ProveedoresDTO prove)
	{
		boolean dato=false;
		int x;
		
		try 
		{
			ps=cnn.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nitproveedor=?");
			ps.setString(3, prove.getName());
			ps.setString(1, prove.getCity());
			ps.setString(2, prove.getAddress());
			ps.setString(4, prove.getTele());
			ps.setInt(5, prove.getNit() );
			
			x=ps.executeUpdate();
			if(x>0)
			{
				dato=true;
			}
			
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return dato;
	}
	
	
	
	
	//ELIMINAR PROVEEDOR 
	
	public int eliminarproveedor(ProveedoresDTO prove)
	{
		int x=0;
		
		try 
		{
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, prove.getNit());
			x=ps.executeUpdate();
			
			
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor " + e);
			e.printStackTrace();
		}
		
	return x;
	}
	
	
}
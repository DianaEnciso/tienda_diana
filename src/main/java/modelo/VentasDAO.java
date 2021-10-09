package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.Conexion;

public class VentasDAO 
{

	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	
	
	//INSERTAR VENTA
	
	public boolean insertarventa(VentasDTO ven)
	{
		
		
		boolean dato=false;
		
		try 
		{
			ps=cnn.prepareStatement("INSERT INTO ventas(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) VALUES(?,?,?,?,?)");
			ps.setInt(1, ven.getCedula_cliente());
			ps.setInt(2, ven.getCedula_usuario());
			ps.setDouble(3, ven.getIvaventa());
			ps.setDouble(4, ven.getTotal_venta());
			ps.setDouble(5, ven.getValor_venta());
			
			dato=ps.executeUpdate()>0;
			
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al insertar venta" + e);
			e.printStackTrace();
		}
		
		return dato;
		
	}
	
	
	
	
}

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Conexion;

public class ProductosDAO {

	Conexion con = new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ProductosDTO cons;
	
	
	
	//SUBIR ARCHIVO CSV
	
	public boolean cargararchivocsv(String URL)
	{
		
		boolean result=false;
		
		try
		{
			//lines= limite de la fila (\r es un enter \n salto de linea
			ps=cnn.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			
			//si lo que trae result es mayor que 0 devuelve true sino ya finaliza.
			result=ps.executeUpdate()>0;
			
			
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Error al registrar producto"+e);
		}
		
		return result;
	}
	
	
	//CONSULTAR
	
	public ProductosDTO ConsultarProducto(ProductosDTO prod) 
	{
		
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			ps.setInt(1, prod.getCod_pro());
			rs=ps.executeQuery();
			if(rs.next()) 
			{
				cons = new ProductosDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6));				
			}
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error al consultar el producto: " + e);
		}
		
		return cons;
	}
	
	
	//ACTUALIZAR
	
	public boolean ActualizarProductos(ProductosDTO prod) 
	{
		int a;
		boolean dato=false;
		
			try {
				ps=cnn.prepareStatement("UPDATE productos SET ivacompra=?, nitproveedor=?, nombre_producto=?, precio_compra=?, precio_venta=? WHERE codigo_producto=?");
				ps.setInt(1, prod.getIva_com());
				ps.setInt(2, prod.getNit_prov());
				ps.setString(3, prod.getNom_prod());
				ps.setInt(4, prod.getPre_com());
				ps.setInt(5, prod.getPre_ven());
				ps.setInt(6, prod.getCod_pro());
				a = ps.executeUpdate();
				if(a>0) {
					dato = true;
				}
			} catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e);
			}
		
		return dato;
	}
	
	
}
package modelo;

public class ClientesDTO 

{
	private int cedula_clien;
	private String nombre_clien;
	private String direccion__clien;
	private String email_clien;
	private String telef_clien;
	
	
	
	public ClientesDTO(int cedula_clien, String direccion__clien, String email_clien, String nombre_clien,
			String telef_clien) 
	
	{
		super();
		this.cedula_clien = cedula_clien;
		this.nombre_clien = nombre_clien;
		this.direccion__clien = direccion__clien;
		this.email_clien = email_clien;
		this.telef_clien = telef_clien;
	}


	
//CONSTRUCTOR PARA BUSCAR POR CEDULA DE CLIENTE//
	public ClientesDTO(int cedula_clien) 
	{
		super();
		this.cedula_clien = cedula_clien;
	}






	public int getCedula_clien() 
	{
		return cedula_clien;
	}



	public void setCedula_clien(int cedula_clien) 
	{
		this.cedula_clien = cedula_clien;
	}



	public String getNombre_clien() 
	{
		return nombre_clien;
	}



	public void setNombre_clien(String nombre_clien) 
	{
		this.nombre_clien = nombre_clien;
	}



	public String getDireccion__clien() 
	{
		return direccion__clien;
	}



	public void setDireccion__clien(String direccion__clien) 
	{
		this.direccion__clien = direccion__clien;
	}



	public String getEmail_clien() 
	{
		return email_clien;
	}



	public void setEmail_clien(String email_clien) 
	{
		this.email_clien = email_clien;
	}



	public String getTelef_clien() 
	{
		return telef_clien;
	}



	public void setTelef_clien(String telef_clien) 
	{
		this.telef_clien = telef_clien;
	}
	
	
}
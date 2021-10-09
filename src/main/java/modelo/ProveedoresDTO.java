package modelo;

public class ProveedoresDTO 
{
	private int nit;
	private String name;
	private String city;
	private String address;
	private String tele;
	
	
	public ProveedoresDTO(int nit, String city, String address, String name, String tele) 
	{
		super();
		this.nit = nit;
		this.name = name;
		this.city = city;
		this.address = address;
		this.tele = tele;
	}


	public ProveedoresDTO(int nit) 
	{
		super();
		this.nit = nit;
	}

	
	
	
	//Getter and Setter

	public int getNit() 
	{
		return nit;
	}


	public void setNit(int nit) 
	{
		this.nit = nit;
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getCity() 
	{
		return city;
	}


	public void setCity(String city) 
	{
		this.city = city;
	}


	public String getAddress() 
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
	}


	public String getTele() 
	{
		return tele;
	}


	public void setTele(String tele) 
	{
		this.tele = tele;
	}
	
	
	
	
	
	
	
}
package modelo;

public class ProductosDTO {
	private int cod_pro;
	private int iva_com;
	private int nit_prov;
	private String nom_prod;
	private int pre_com;
	private int pre_ven;
	
	public ProductosDTO(int cod_pro, int iva_com, int nit_prov, String nom_prod, int pre_com, int pre_ven) {
		this.cod_pro = cod_pro;
		this.iva_com = iva_com;
		this.nit_prov = nit_prov;
		this.nom_prod = nom_prod;
		this.pre_com = pre_com;
		this.pre_ven = pre_ven;
	}

	public ProductosDTO(int cod_pro) {
		
		this.cod_pro = cod_pro;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getIva_com() {
		return iva_com;
	}

	public void setIva_com(int iva_com) {
		this.iva_com = iva_com;
	}

	public int getNit_prov() {
		return nit_prov;
	}

	public void setNit_prov(int nit_prov) {
		this.nit_prov = nit_prov;
	}

	public String getNom_prod() {
		return nom_prod;
	}

	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}

	public int getPre_com() {
		return pre_com;
	}

	public void setPre_com(int pre_com) {
		this.pre_com = pre_com;
	}

	public int getPre_ven() {
		return pre_ven;
	}

	public void setPre_ven(int pre_ven) {
		this.pre_ven = pre_ven;
	}
	
	
	
	
}


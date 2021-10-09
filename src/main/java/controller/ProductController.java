package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProductosDAO;
import modelo.ProductosDTO;

/**
 * Servlet implementation class ProductCrontroller
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int c, i, n, pc, pv;
		String nom;
		boolean res;
		ProductosDTO proddto;
		ProductosDAO proddao;
		ProductosDTO recoldat;
		
		//CONSULTAR
		if (request.getParameter("btn_consPD")!=null) 
		{
			int cod;
			
			c=Integer.parseInt(request.getParameter("cod"));
			proddto = new ProductosDTO(c);
			proddao = new ProductosDAO();
			recoldat = proddao.ConsultarProducto(proddto);
			
			
			if(recoldat!=null)
			{
				cod=recoldat.getCod_pro();
				i=recoldat.getIva_com();
				n=recoldat.getNit_prov();
				nom=recoldat.getNom_prod();
				pc=recoldat.getPre_com();
				pv=recoldat.getPre_ven();
				
				
				
				response.sendRedirect("Menu_Productos.jsp?cod="+cod+"&&nom="+nom+"&&nit="+n+"&&prec_c="+pc+"&&iva="+i+"&&prec_v="+pv);
				JOptionPane.showMessageDialog(null,"Producto encontrado");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "El producto no se encuentra registrado.");
				response.sendRedirect("Menu_Productos.jsp");
			}
		}
			
			
		//ACTUALIZAR
		if(request.getParameter("btn_actPD")!=null)
		{
			c=Integer.parseInt(request.getParameter("cod"));
			i=Integer.parseInt(request.getParameter("iva"));
			n=Integer.parseInt(request.getParameter("nit"));
			nom=request.getParameter("nom");
			pc=Integer.parseInt(request.getParameter("prec_c"));
			pv=Integer.parseInt(request.getParameter("prec_v"));
			
			proddto = new ProductosDTO(c, i, n, nom, pc, pv);
			proddao = new ProductosDAO();
			res = proddao.ActualizarProductos(proddto);
			
			if(res) 
			{
				JOptionPane.showMessageDialog(null, "Producto actualizado.");
				response.sendRedirect("Menu_Productos.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Producto no actualizado.");
				response.sendRedirect("Menu_Productos.jsp");
			}
			
		}	
			
			
	}
}


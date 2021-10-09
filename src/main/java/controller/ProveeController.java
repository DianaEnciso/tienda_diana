package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class ProveeController
 */
@WebServlet("/ProveeController")
public class ProveeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveeController() {
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
		
		
		int nit;
		String name, city, address, tele;
		
		boolean respu;
		
		ProveedoresDAO prodao;
		ProveedoresDTO prodto;
		ProveedoresDTO proguard;
		
		
		//INSERTAR PROVEEDOR
		
		if(request.getParameter("btning")!=null)
		{
			nit=Integer.parseInt(request.getParameter("nit"));
			
			
				
				name=request.getParameter("nombre");
				city=request.getParameter("ciudad");
				address=request.getParameter("direccion");
				tele=request.getParameter("telefono");
			
			
			if(name.equals("") || city.equals("") || address.equals("") || tele.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
				//request.getRequestDispatcher("Menu_Proveedores.jsp").forward(request, response);
				response.sendRedirect("Menu_Proveedores.jsp");
				
			}
			else
			{
				prodto= new ProveedoresDTO(nit, city, address, name, tele);
				prodao= new ProveedoresDAO();
				
				respu=prodao.insertarproveedor(prodto);
				
				if(respu==true)
				{
					JOptionPane.showMessageDialog(null, "Proveedor registrado");
					response.sendRedirect("Menu_Proveedores.jsp");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Proveedor no registrado");
					response.sendRedirect("Menu_Proovedores.jsp");
				}
			}
		}
		

	
		
		//CONSULTAR PROVEEDOR
		
		
		if(request.getParameter("btnconsu")!=null)
		{
			int num_nit;
			
			nit=Integer.parseInt(request.getParameter("nit"));
			prodto= new ProveedoresDTO(nit);
			prodao= new ProveedoresDAO();
			proguard=prodao.consultarproveedor(prodto);
			
			if(proguard!=null)
			{
				num_nit=proguard.getNit();
				name=proguard.getName();
				city=proguard.getCity();
				address=proguard.getAddress();
				tele=proguard.getTele();
				
				response.sendRedirect("Menu_Proveedores.jsp?nit="+num_nit+"&&ciu="+city+"&&dir="+address+"&&nom="+name+"&&tel="+tele);
				JOptionPane.showMessageDialog(null, "Proveedor consultado y encontrado");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El proveedor no existe en la base de datos");
				response.sendRedirect("Menu_Proveedores.jsp");
			}
			
		}
		
		
		
		//ACTUALIZAR PROVEEDOR
		
		if(request.getParameter("btnactua")!=null)
		{
			boolean dato;
			
			nit=Integer.parseInt(request.getParameter("nit"));
			name=request.getParameter("nombre");
			city=request.getParameter("ciudad");
			address=request.getParameter("direccion");
			tele=request.getParameter("telefono");
			
			prodto= new ProveedoresDTO(nit, city, address, name, tele);
			prodao= new ProveedoresDAO();
			dato=prodao.actualizar(prodto);
			
			if(dato=true)
			{
				JOptionPane.showMessageDialog(null, "El proveedor ha sido actualizado");
				response.sendRedirect("Menu_Proveedores.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El proveedor no pudo ser actualizado");
				response.sendRedirect("Menu_Proveedores.jsp");
			}
		}
		
		//ELIMINAR PROVEEDOR
		
		if(request.getParameter("btnelimi")!=null)
		{
			
			int p=0;
			nit=Integer.parseInt(request.getParameter("nit"));
			prodto= new ProveedoresDTO(nit);
			prodao= new ProveedoresDAO();
			p=prodao.eliminarproveedor(prodto);
			
			if(p>0)
			{
				JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
				response.sendRedirect("Menu_Proveedores.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El proveedor no pudo ser eliminado");
				response.sendRedirect("Menu_Proveedores.jsp");
			}
		}
		
	}

	
}

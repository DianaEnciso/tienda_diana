package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;



/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
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
		//INGRESAR UN CLIENTE
		
		int ced;
		String name, direc, email, tele;
		
		boolean respu;
		
		ClientesDTO clidto=null;
		ClientesDAO clidao;
		ClientesDTO cliguard;
		
		if(request.getParameter("btning")!=null)
		{
			ced=Integer.parseInt(request.getParameter("cedula"));
			name=request.getParameter("nombre");
			direc=request.getParameter("direccion");
			email=request.getParameter("correo");
			tele=request.getParameter("telefono");
			
				
				if(name.equals("") || direc.equals("") || email.equals("") || tele.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
					response.sendRedirect("Menu_Cliente.jsp");
				}
				else
				{
					clidto= new ClientesDTO(ced, direc, email, name, tele);
					clidao= new ClientesDAO();
					
					respu=clidao.insertaruncliente(clidto);
					
					
					if(respu==true)
					{
						JOptionPane.showMessageDialog(null, "Cliente registrado");
						response.sendRedirect("Menu_Cliente.jsp");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "Cliente no registrado");
						response.sendRedirect("Menu_Cliente.jsp");
					}
					
				}
					
					
				}
				
		
				
			
			
		
		
		//CONSULTAR UN CLIENTE
		
		
		if(request.getParameter("btnconsu")!=null)
		{
			int cedu;
			
			ced=Integer.parseInt(request.getParameter("cedula"));
			clidto= new ClientesDTO(ced);
			clidao= new ClientesDAO();
			cliguard=clidao.consultarunCliente(clidto);
			
			if(cliguard!=null)
			{
				cedu=cliguard.getCedula_clien();
				name=cliguard.getNombre_clien();
				direc=cliguard.getDireccion__clien();
				email=cliguard.getEmail_clien();
				tele=cliguard.getTelef_clien();
				
				
				response.sendRedirect("Menu_Cliente.jsp?ced="+cedu+"&&dire="+direc+"&&ema="+email+"&&nam="+name+"&&tel="+tele);
				JOptionPane.showMessageDialog(null, "Cliente consultado y encontrado");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos");
				response.sendRedirect("Menu_Cliente.jsp");
			}
			
			
	}
		
		//ACTUALIZAR CLIENTE
		
		if(request.getParameter("btnactua")!=null)
		{
			
			boolean dat;
			
			ced=Integer.parseInt(request.getParameter("cedula"));
			name=request.getParameter("nombre");
			direc=request.getParameter("direccion");
			email=request.getParameter("correo");
			tele=request.getParameter("telefono");
			
			clidto= new ClientesDTO(ced, direc, email, name, tele);
			clidao= new ClientesDAO();
			dat=clidao.actualizar(clidto);
			
			
			if(dat==true)
			{
				JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado");
				response.sendRedirect("Menu_Cliente.jsp");
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El cliente no pudo ser actualizado");
				response.sendRedirect("Menu_Cliente.jsp");
			}
			
		}
		
		
		//ELIMINAR UN CLIENTE
		
		if(request.getParameter("btnelimi")!=null)
		{
			
			int e=0;
			ced=Integer.parseInt(request.getParameter("cedula"));
			clidto= new ClientesDTO(ced);
			clidao= new ClientesDAO();
			e=clidao.eliminarCliente(clidto);
			
			if(e>0)
			{
				
				JOptionPane.showMessageDialog(null, "El cliente fue eliminado");
				response.sendRedirect("Menu_Cliente.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El cliente no pudo ser eliminado");
				response.sendRedirect("Menu_Cliente.jsp");
			}
			
		}
		

	}
}

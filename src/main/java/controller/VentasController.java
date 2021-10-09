package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;


/**
 * Servlet implementation class VentasController
 */
@WebServlet("/VentasController")
public class VentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cant1,cant2,cant3,cantot;
	double iva,iva1,iva2,pre1,pre2,pre3,resultado,resultado1,resultado2,totalsin_iva,total_ivas,total_pagar,total1,total2,total3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentasController() {
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
		
		//CONSULTA DE CLIENTE
	
		HttpSession sesion=request.getSession();
		
		if(request.getParameter("btnconsultar")!=null)
		{
			
			int cedula;
						
			ClientesDTO listado;
			cedula=Integer.parseInt(request.getParameter("cedula"));
			ClientesDAO clidao=new ClientesDAO();
			ClientesDTO clidto=new ClientesDTO(cedula);
			listado=clidao.consultarunCliente(clidto);
			
			sesion.setAttribute("clientes", listado);
			//response.sendRedirect("Menu_Ventas.jsp");
			request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			
		}
		
		
		//BUSQUEDA PRIMER PRODUCTO
		
		if(request.getParameter("buscar")!=null)
		{
			int codpro;
			ProductosDTO listapro;
			codpro=Integer.parseInt(request.getParameter("codigo"));
			ProductosDTO prodto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro=prodao.ConsultarProducto(prodto);
			
			
			if(listapro!=null)
			{
				iva=listapro.getIva_com();
				sesion.setAttribute("productos", listapro);
				sesion.setAttribute("Iva", listapro);
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El producto no existe, intente de nuevo");
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			}
			
		}
		
		
			
		//BUSQUEDA SEGUNDO PRODUCTO
		
		if(request.getParameter("buscar1")!=null)
		{
			int codpro;
			ProductosDTO listapro1;
			codpro=Integer.parseInt(request.getParameter("codigo1"));
			ProductosDTO prodto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro1=prodao.ConsultarProducto(prodto);
			
			
			
			if(listapro1!=null)
			{
				iva1=listapro1.getIva_com();
				sesion.setAttribute("productos1", listapro1);
				sesion.setAttribute("Iva1", listapro1);
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El producto no existe, intente de nuevo");
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			}
			
			
		}
		
		
		//BUSQUEDA TERCER PRODUCTO
		if(request.getParameter("buscar2")!=null) 
		{
		
			int codpro;
			ProductosDTO listapro2;
			codpro=Integer.parseInt(request.getParameter("codigo2"));
			ProductosDTO prodto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro2=prodao.ConsultarProducto(prodto);
			
			
			if(listapro2!=null)
			{
				iva2=listapro2.getIva_com();
				sesion.setAttribute("productos2", listapro2);
				sesion.setAttribute("Iva2", listapro2);			
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El producto no existe, intente de nuevo");
				request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
			}
			
			
			
		}
		
		
		
		//OPERACIONES, SI DA CLICK EN BOTÓN DE VENTA
		
		
		if(request.getParameter("calcular")!=null)
		{
			
					
				    
					
					cant1=Integer.parseInt(request.getParameter("cant"));
					cant2=Integer.parseInt(request.getParameter("cant1"));
					cant3=Integer.parseInt(request.getParameter("cant2"));			
					pre1=Double.parseDouble(request.getParameter("precio"));
					pre2=Double.parseDouble(request.getParameter("precio1"));
					pre3=Double.parseDouble(request.getParameter("precio2"));
									
					cantot=cant1+cant2+cant3;
					resultado=cant1*pre1;
					resultado1=cant2*pre2;
					resultado2=cant3*pre3;
					
					
					total1=resultado*iva/100;
					total2=resultado1*iva1/100;
					total3=resultado2*iva2/100;
					
					//suma de precios sin iva
					//totalsin_iva=Math.round(resultado+resultado1+resultado2);
					totalsin_iva=resultado+resultado1+resultado2;
					//suma de los ivas de cada producto
					//total_ivas=Math.round(total1+total2+total3);
					total_ivas=total1+total2+total3;
					
					//total de los productos sin iva MÁS los ivas de cada producto
					//total_pagar=Math.round(totalsin_iva+total_ivas);
					total_pagar=totalsin_iva+total_ivas;
					
					///////////////////////////////
					sesion.setAttribute("canti1", cant1);
					sesion.setAttribute("canti2", cant2);
					sesion.setAttribute("canti3", cant3);
					sesion.setAttribute("Total", total_pagar);
					sesion.setAttribute("IVAS", total_ivas);
					sesion.setAttribute("sinIv", totalsin_iva);
					sesion.setAttribute("cantot", cantot);
					request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
					////////////////////////
					
					//IMPRESIÓN DE VENTANA PARA CONFIRMAR VENTA
		}
					if(request.getParameter("total")!=null) 
					{
						int u=JOptionPane.showConfirmDialog(null, "Artículo 1 "+resultado+ "\n"+"Artículo 2 "+resultado1+ "\n"+"Artículo 3 "+resultado2+"\n"
						+"\nIVA 1 "+total1+ "\n"+"\nIVA 2 "+total2+"\n"+"\nIVA 3 "+total3+"\n"+"\nTotal Sin IVA "+totalsin_iva+"\n"+"\nTotal IVA "+total_ivas+
						"\n"+"\nTotal a Pagar "+total_pagar+"\n");
					
					
								
					
					//SI ACEPTA VENTA
		
					if(u==0)
					{
						JOptionPane.showMessageDialog(null, "entro al if del 0");
						String cedcli,cedusu;
						int ced_cli,ced_usu;
						double ivas, tot_iva,totcon_iva;
						boolean res;
						
						cedcli=(request.getParameter("cedula"));
						cedusu=(request.getParameter("cedulausu"));
						
						ivas=total_ivas;
						tot_iva=totalsin_iva;
						totcon_iva=total_pagar;
						ced_cli=Integer.parseInt(cedcli);
						ced_usu=Integer.parseInt(cedusu);
						
						VentasDTO ven=new VentasDTO(ced_cli, ced_usu, ivas, tot_iva, totcon_iva);
						VentasDAO vendao= new VentasDAO();
						JOptionPane.showMessageDialog(null, "envio al dao");
						res=vendao.insertarventa(ven);
						
						
						
						if(res) 
						{
							JOptionPane.showMessageDialog(null, "Venta registrada");
							request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
												
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Venta NO registrada");
							request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
						}
					}
					
					
					//SI NIEGA VENTA
					
					else if(u==1)
					{
						request.getRequestDispatcher("Menu_Ventas.jsp").forward(request, response);
						
					}
					
					
					//SI CANCELA VENTA
					
					else if(u==2)
					{
						JOptionPane.showMessageDialog(null, "Venta cancelada");
						sesion.invalidate();
						request.getRequestDispatcher("index.jsp").forward(request, response);
						
					}
			
				
			}
		
		else if(request.getParameter("reset")!=null)
				{
					sesion.invalidate();
					response.sendRedirect("index.jsp");
				
				}
		
		}
	}




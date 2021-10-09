package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import modelo.UsuariosDAO;
import modelo.UsuariosDTO;


@WebServlet("/StoreController")
public class StoreController extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    
    public StoreController() 
    {
        super();
        
    }

/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//VALIDACION DE LOGIN
		String u,p;
		
		if(request.getParameter("btnlogin")!=null) 
		{
		u= request.getParameter("user");
		p= request.getParameter("pass");
		
		if(u.equals("admininicial")&& p.equals("admin123456")) 
		{
		
			response.sendRedirect("home.jsp?dato="+u);
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"“Usuario o contraseña errados, intente de nuevo");
			response.sendRedirect("index.jsp");
		}
		}
	}
	
*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		// INGRESAR UN USUARIO
		
		int ced;
		String corr, name, pass, usu;
		
		boolean respu;
		
		UsuariosDTO usudto;
		UsuariosDAO usudao;
		UsuariosDTO guardato;
		
		
		
		if(request.getParameter("btning")!=null)
		{
			ced=Integer.parseInt(request.getParameter("cedula"));
			
			
			corr=request.getParameter("correo");
			name=request.getParameter("nombre");
			pass=request.getParameter("clave");
			usu=request.getParameter("usuario");
			
			if(corr.equals("") || name.equals("") || pass.equals("") || usu.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
				response.sendRedirect("Menu_Usuario.jsp");
				
			}
			else
			{
				usudto= new UsuariosDTO(ced, corr, name, pass, usu);
				usudao= new UsuariosDAO();
				
				respu=usudao.insertarusuario(usudto);
				
				if(respu==true)
				{
					JOptionPane.showMessageDialog(null, "Usuario registrado");
					response.sendRedirect("Menu_Usuario.jsp");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario no registrado");
					response.sendRedirect("Menu_Usuario.jsp");
				}
				
			}
		}
			
		
		
		
		//CONSULTAR UN USUARIO
		
		if(request.getParameter("btnconsu")!=null)
		{
			int cedu;
			
			
			ced=Integer.parseInt(request.getParameter("cedula"));
			usudto=new UsuariosDTO(ced);
			usudao=new UsuariosDAO();
			guardato=usudao.consultarUnUsuario(usudto);
			
			if(guardato!=null)
			{
					
			cedu=guardato.getCedula_usuario();
			corr=guardato.getEmail_usuario();
			name=guardato.getNombre_usuario();
			pass=guardato.getPassword();
			usu=guardato.getUsuario();
			
			response.sendRedirect("Menu_Usuario.jsp?ce="+cedu+"&&co="+corr+"&&no="+name+"&&cl="+pass+"&&us="+usu);
			JOptionPane.showMessageDialog(null, "Usuario consultado y encontrado");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "El usuario NO existe en la base de datos");
				response.sendRedirect("Menu_Usuario.jsp");
			}
		
			
		}
		
		//ACTUALIZAR USUARIO
		
		if(request.getParameter("btnactua")!=null)
		{
			
			boolean dat;
			
			ced=Integer.parseInt(request.getParameter("cedula"));
			corr=request.getParameter("correo");
			name=request.getParameter("nombre");
			pass=request.getParameter("clave");
			usu=request.getParameter("usuario");
			
			usudto= new UsuariosDTO(ced, corr, name, pass, usu);
			usudao= new UsuariosDAO();
			dat=usudao.actualizar(usudto);
			
			
			if(dat==true)
			{
				JOptionPane.showMessageDialog(null, "El usuario ha sido actualizado");
				response.sendRedirect("Menu_Usuario.jsp");
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El usuario no pudo ser actualizado");
				response.sendRedirect("Menu_Usuario.jsp");
			}
			
		}
			
		
		//ELIMINAR UN USUARIO
	
		if(request.getParameter("btnelimi")!=null)
		{
			int e=0;
			ced=Integer.parseInt(request.getParameter("cedula"));
			usudto=new UsuariosDTO(ced);
			usudao=new UsuariosDAO();
			e=usudao.eliminarusuario(usudto);
			
			
			if(e>0)
			{
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				response.sendRedirect("Menu_Usuario.jsp");
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El usuario no pudo ser eliminado");
				response.sendRedirect("Menu_Usuario.jsp");
			
			
			}
		}
		
		}
	}
	
		

	



package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductosDAO;

/**
 * Servlet implementation class ProductosArchivo
 */
@WebServlet("/ProductosArchivo")
@MultipartConfig
public class ProductosArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosArchivo() {
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
		Part archivo= request.getPart("archivo");
		String Url="D:\\\\TICS\\\\Java-Eclipse\\\\Tienda_Diana\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		
		
		if(request.getParameter("cargar")!=null || request.getParameter("archivo")!=null)
		{
			try
			{
				InputStream file=archivo.getInputStream();
				File copia= new File(Url+"productos.csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				
				while(num !=-1)
				{
					
					escribir.write(num);
					num=file.read();
				}
			
			file.close();
			escribir.close();
			
			boolean x;
			ProductosDAO prodao= new ProductosDAO();
			x=prodao.cargararchivocsv(Url+"productos.csv");
			
			if(x)
			{
				JOptionPane.showMessageDialog(null, "Datos cargados en la base de datos");
				response.sendRedirect("Menu_Productos.jsp");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se cargaron los datos en la base de datos");
				response.sendRedirect("Menu_Productos.jsp");
			
			}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Error: no se subió ningun archivo"+e);
				response.sendRedirect("Menu_Productos.jsp");
			}
			
		}
		else 
		{
			
			JOptionPane.showMessageDialog(null, "“Error: no se seleccionó archivo para cargar");
			response.sendRedirect("Menu_Productos.jsp");
		}
			
		
		
	}
	
	
}

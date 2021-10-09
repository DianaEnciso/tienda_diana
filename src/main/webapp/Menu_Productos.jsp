<%@page import="controller.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Productos</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Menu_Nav.css">
<link rel="stylesheet" href="css/producto.css">



</head>

<%
	Conexion con=new Conexion();
	con.conexiondb();
	
%>

<body>
<%! String u; %>
	<div class="producto">

		<header class="navbar">    
	   		<div class="titulo-logo"> 
	   			<a href="home.jsp"><img alt="Logo minfruver" src="imgs/logo-02.png" class="logo"></a>
	   		</div>
	   		
	           <ul class="main-nav">
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Usuario.jsp"><img alt="Usuarios" src="imgs/items_Mesa de trabajo 1.png">
	               <span class="tooltip_box">Usuarios</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Cliente.jsp"><img alt="Clientes" src="imgs/items-02.png">
	               <span class="tooltip_box">Clientes</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Proveedores.jsp"><img alt="Proveedores" src="imgs/items-03.png">
	               <span class="tooltip_box">Proveedores</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Productos.jsp"><img alt="Productos" src="imgs/items-10.png">
	               <span class="tooltip_box">Productos</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Ventas.jsp"><img alt="Ventas" src="imgs/items-05.png">
	               <span class="tooltip_box">Ventas</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Reportes.jsp"><img alt="Reportes" src="imgs/items-06.png">
	               <span class="tooltip_box">Reportes</span>
	               </a></li>
	               <%
	               //String da = request.getSession().getAttribute("user").toString();
	               HttpSession objetosesion = request.getSession();
	               u=(String)objetosesion.getAttribute("llevanombre");
				   %>
	               <li class="main-nav__itemU"><a href="index.jsp" class="exit_session"><%=u%></a></li>
	           </ul>
	   	</header>
	   	
		<div class="formulario">
			<h2>Gestión de productos</h2>
			<%
			String c="", i="", n="", nom="", pc="", pv="";
			if (request.getParameter("cod")!=null){
				c=request.getParameter("cod");
				i=request.getParameter("iva");
				n=request.getParameter("nit");
				nom = request.getParameter("nom");
				pc = request.getParameter("prec_c");
				pv = request.getParameter("prec_v");
			}
			%>
	
			<form action="ProductController" method="post" class="userForm">
		    	<label for="user-cc">Código del producto</label>
		    	<input type="text" name="cod" placeholder="Digita el código del producto"  value="<%=c%>" required> 
		    	<label for="user-cc">Nombre del producto</label>
		    	<input type="text" name="nom" placeholder="Digita el nombre del producto" value="<%=nom%>" > 
		    	<label for="user-cc">Nit del proveedor</label>
		    	<input type="text" name="nit" placeholder="Digita tel NIT del proveedor"  value="<%=n%>"> 
		    	<label for="user-cc">Precio compra</label>
		    	<input type="text" name="prec_c" placeholder="Digita el precio de compra"  value="<%=pc%>"> 
		    	<label for="user-cc">IVA compra</label>
		    	<input type="text" name="iva" placeholder="Digita el IVA"  value="<%=i%>"> 
		    	<label for="user-cc">Precio venta</label>
		    	<input type="text" name="prec_v" placeholder="Digita el precio de venta" value="<%=pv%>" >  
		    	<div class="send_data" id="sd_prod">
			    	<!--<input type="submit" name="btn_crearU" value="Crear">-->
			    	
			     	<input type="submit" name="btn_consPD" value="Consultar">
			    	<input type="submit" name="btn_actPD" value="Actualizar">
			    	
			    	<!--<input type="submit" name="btn_elimPD" value="Eliminar">-->
			    
			    </div>  	    	
		    </form>	
		</div> 
		<div class="form-archivo">
		<form action="ProductosArchivo" method="post" enctype="multipart/form-data" class="archivos">
		
			<input id="productos" type="file" accept=".csv" name="archivo" value="Examinar">
			
			<input type="submit" name="cargar" value="Subir archivo" id="submarch" class="btnsubir">
		
		</form>
		</div>
		
		
		
		
		
		
		
		<div class="footer">
	    	<div class="logoFooter">
	    		<img alt="logo" src="imgs/logo-misiontic.png" width="100px">
	    	</div>
	    	
	    	<div class="logo-universidad"> 
	    		<img alt="Logo minfruver" src="imgs/logo-universidad.png" width="100px"></a>
	    	</div>
	    
	    	<div class="description">
	    		<p style="text-align: center; border-bottom: 1px solid #ffffff;"><b>MisionTic - Universidad del Bosque 2021</b></p> 
	    		<p style="padding: 5px 0 0 0"><b>Nuestra meta: </b>Enfrentar los desafíos de la cuarta Revolución Industrial.</p>
	    		<p><b>Autores: </b>Lina Pérez, Evelyn Perozo, Diego Ramírez, Diana Rodríguez</p>
	    	</div>
	    
	    	<div class="InfoGeneral">
		    	<p>Siguenos en nuestras redes sociales</p>
		    	<div class="redesSociales">
			    	<a><img alt="Facebook" src="imgs/facebook.svg"></a>
			    	<a><img alt="Instagram" src="imgs/instagram.svg"></a>
			    	<a><img alt="Twitter" src="imgs/twitter.svg"></a>
		    	</div>
		    	<div class="copyright">
		    		<p><small>Copyright &copy 2021. All Rights Reserved</small></p>
		    	</div>
	    	</div>
	    </div>  	       
	</div>
</body>
</html>


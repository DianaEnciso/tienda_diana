<%@page import="controller.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultasgenerales.js"></script>

<title>Menu Reporte</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Menu_Nav.css">
<link rel="stylesheet" href="css/reporte.css">



</head>

<%
	Conexion con=new Conexion();
	con.conexiondb();
%>

<body>

<body>
<%!String u; %>
	<div class="reporte">

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
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Productos.jsp"><img alt="Productos" src="imgs/items-04.png">
	               <span class="tooltip_box">Productos</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Ventas.jsp"><img alt="Ventas" src="imgs/items-05.png">
	               <span class="tooltip_box">Ventas</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Reportes.jsp"><img alt="Reportes" src="imgs/items-12.png">
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
	   		<h2>Bienvenido al Menú de Reportes</h2>
	   	
	   	
	   	<form action="">
	   	
	   		<input class="btnconsulta_uno" type="button"  value="Listado de Usuarios">
	   		<input class="btnconsulta_dos" type="button"  value="Listado de Clientes">
	   	   	<input class="btnconsulta_tres" type="button"  value="Detalles de Venta">
	   	   	
	   	</form>
	   	<table id="table"></table>
	   	
	   	
	   	
	   	
	   	
	   	</div>
	   	
	   	
	   	<div class="footer">
	    	<div class="logoFooter">
	    		<img alt="logo" src="imgs/logo-misiontic.png" width="100px">
	    	</div>
	    	
	    	<div class="logo-universidad"> 
	    		<img alt="Logo minfruver" src="imgs/logo-universidad.png" width="100px">
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
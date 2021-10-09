<%@page import="controller.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Clientes</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Menu_Nav.css">
<link rel="stylesheet" href="css/cliente.css">
</head>

<%
	Conexion con=new Conexion();
	con.conexiondb();
%>

<body>
<%! String u; %>
	<div class="cliente">

		<header class="navbar">    
	  		<div class="titulo-logo"> 
	  			<a href="home.jsp"><img alt="Logo minfruver" src="imgs/logo-02.png" class="logo"></a>
	  		</div>
	  		
	        <ul class="main-nav">
	            <li class="main-nav__item"><a class="tooltip" href="Menu_Usuario.jsp"><img alt="Usuarios" src="imgs/items_Mesa de trabajo 1.png">
	            <span class="tooltip_box">Usuarios</span>
	            </a></li>
	            <li class="main-nav__item"><a class="tooltip" href="Menu_Cliente.jsp"><img alt="Clientes" src="imgs/items-08.png">
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

    		<h2>Bienvenido Cliente</h2>
			<%
				String ced="",name="",direc="",email="",tele="";
				
				if(request.getParameter("ced")!=null)
				{
					
				ced=request.getParameter("ced");
				name=request.getParameter("nam");
				direc=request.getParameter("dire");
				email=request.getParameter("ema");
				tele=request.getParameter("tel");
				}
			%>

			<form action="ClientController" method="post" class="userForm">
				<label for="user-cc" >Cédula</label>
				<input type="text" name="cedula" value="<%=ced%>" placeholder="Digita tu Cédula" required>
				<label for="user-cc" >Nombre Completo</label>
				<input type="text" name="nombre" value="<%=name%>" placeholder="Digita tu Nombre Completo" >
				<label for="user-cc" >Dirección</label>
				<input type="text" name="direccion" value="<%=direc%>" placeholder="Digita tu Dirección" >
				<label for="user-cc" >Correo Electrónico</label>
				<input type="email" name="correo" value="<%=email%>" placeholder="Digita tu Correo Electrónico" >
				<label for="user-cc" >Teléfono</label>
				<input type="text" name="telefono" value="<%=tele%>" placeholder="Digita tu Teléfono" >
		
				<div class="send_data">
					<input type="submit" name="btning" value="Crear">
					<input type="submit" name="btnconsu" value="Consultar">
					<input type="submit" name="btnactua" value="Actualizar">
					<input type="submit" name="btnelimi" value="Eliminar"> 
				</div>
		
			</form>
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
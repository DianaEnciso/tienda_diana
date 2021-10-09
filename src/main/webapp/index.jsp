<%@page import="controller.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MinFruver</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Menu_Nav.css">
</head>

<%
	Conexion con=new Conexion();
	con.conexiondb();
%>

<body>
	<div class="home">

 		<header class="navbar">    
    		<div class="titulo-logo"> 
    			<a href="home.jsp"><img alt="Logo minfruver" src="imgs/MinFruver_logo_Mesa de trabajo 1.png" class="logo"></a>
    		</div>
      
            <ul class="main-nav">
                <li class="main-nav__item"><a href="Menu_Usuario.jsp"><img alt="Usuarios" src="imgs/items_Mesa de trabajo 1.png"></a></li>
                <li class="main-nav__item"><a href="Menu_Cliente.jsp"><img alt="Clientes" src="imgs/items-02.png"></a></li>
                <li class="main-nav__item"><a href="Menu_Proveedores.jsp"><img alt="Proveedores" src="imgs/items-03.png"></a></li>
                <li class="main-nav__item"><a href="Menu_Productos.jsp"><img alt="Productos" src="imgs/items-04.png"></a></li>
                <li class="main-nav__item"><a href="Menu_Ventas.jsp"><img alt="Ventas" src="imgs/items-05.png"></a></li>
                <li class="main-nav__item"><a href="Menu_Reportes.jsp"><img alt="Reportes" src="imgs/items-06.png"></a></li>
                <li class="main-nav__itemU"><a href="Menu_Usuario.jsp" class="exit_session">Usuario</a></li>
            </ul>
    	</header>

		<main class="main">

			<div class="contenedor contenedor1">
	
				<div class="window-notice" id="window-notice">
		        	<div class="content">
				        <!--  <div class="titulo-logo"> 
				    		<div class="logo1"></div>
				    	</div> -->
							
						<img class="logo1" alt="logo" src="imgs/MinFruver_logo_Mesa de trabajo 1.png">
						
						<form action="LoginController" method="post" >
							
							<div class="info">
								<label>Usuario</label>
								<input type="text" name="user">
					
								<label>Contraseña</label>
								<input type="password" name="pass">
							</div>
							
							<div class="info_btn">
								<input type="submit" value="Aceptar" name="btnlogin" class="btn1">
								<input type="reset" value="Cancelar" name="cancel" class="btn2">
							</div>	
							
						</form>
					</div>	
				</div>	
			</div>

		</main>	
		
		<div class="footer footer_index">
	    	<div class="logoFooter">
	    		<img alt="logo" src="imgs/logo-misiontic.png" width="100px">
	    	</div>
	    	
	    	<div class="logo-universidad"> 
	    		<img alt="Logo minfruver" src="imgs/logo-universidad.png" width="100px"></a>
	    	</div>
	    
	    	<div class="description">
	    		<p style="text-align: center; border-bottom: 1px solid #ffffff;"><b>MisionTic - Universidad del Bosque 2021</b></p> 
	    		<p style="padding: 5px 0 0 0"><b>Nuestra meta: </b>Enfrentar los desafios de la cuarta Revolución Industrial.</p>
	    		<p><b>Autores: </b>Diana Enciso, Lina Pérez, Evelyn Perozo, Diego Ramírez</p>
	    	</div>
	    
	    	<div class="InfoGeneral">
		    	<p>Siguenos en nuestras redes sociales</p>
		    	<div class="redesSociales">
			    	<a><img alt="Facebook" src="imgs/facebook.svg"></a>
			    	<a><img alt="Instagram" src="imgs/instagram.svg"></a>
			    	<a><img alt="Twitter" src="imgs/twitter.svg"></a>
		    	</div>
		    	<div class="copyright">
		    		<p><small>Copyright &copy 2021, all rights reserved</small></p>
		    	</div>
	    	</div>
	    </div>
	
	</div>

</body>
</html>
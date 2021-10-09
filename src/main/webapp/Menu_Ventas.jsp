<%@page import="controller.Conexion"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Ventas</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/Menu_Nav.css">
<link rel="stylesheet" href="css/venta.css">
</head>

<%
	Conexion con=new Conexion();
	con.conexiondb();
%>

<body>

<%!String u; %>
	<div class="venta">

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
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Ventas.jsp"><img alt="Ventas" src="imgs/items-11.png">
	               <span class="tooltip_box">Ventas</span>
	               </a></li>
	               <li class="main-nav__item"><a class="tooltip" href="Menu_Reportes.jsp"><img alt="Reportes" src="imgs/items-06.png">
	               <span class="tooltip_box">Reportes</span>
	               </a></li>
	               <%
	               //String da = request.getSession().getAttribute("user").toString();
	               HttpSession objetosesion = request.getSession();
	               HttpSession sesion = request.getSession();
	               u=(String)objetosesion.getAttribute("llevanombre");
				   %>
                <li class="main-nav__itemU"><a href="index.jsp" class="exit_session"><%=u%></a></li>
            </ul>
	   	</header>
	   	
	   	
	   	
	   	
	   	<div class="formulario">
	   		<h2>Bienvenido al Menú de Ventas</h2>
	   		<form action="VentasController" method="post" id="form">
		    	
		    		<input type="hidden" name="cedulausu" value="${cedula}">
		    		<input type="text" name="cedula" value="${clientes.getCedula_clien()}" placeholder="cedula">
			    	<input type="text" name="nombre" value="${clientes.getNombre_clien()}" placeholder="nombre">
			    	
			    	<input type="submit" name="btnconsultar" value="Consultar">
			    	
			    
			    
					    	
		<table class="tabla">
			<tbody>
			<tr>
				<th>Código del Producto</th>
				<th>Cantidad</th>
				<th></th>
				<th>Nombre del Producto</th>
				<th>IVA</th>
				<th>Precio Total</th>
			</tr>
			
			<tr>
			
				<td><input type="text" name="codigo" value="${productos.getCod_pro()}"></td>
				<td><input type="number" class="cantidad" id="canti" name="cant" value="${canti1 }" ></td>
				<td><input type="submit" name="buscar" value="Confirmar"></td>
				<td><input type="text" class="nombre" name="nompro" value="${productos.getNom_prod()}"></td>
				<td><input type="text" class="iva" value="${Iva.getIva_com()}"></td> 
				<td><input type="text" class="pre" id="preci" name="precio" value="${productos.getPre_ven()}"></td>
				
			</tr>
			
			<tr>
				
				<td><input type="text" name="codigo1" value="${productos1.getCod_pro()}"></td>
				<td><input type="number" class="cantidad1" id="canti1" name="cant1" value="${canti2 }" ></td>
				<td><input type="submit" name="buscar1" value="Confirmar"></td>
				<td><input type="text" class="nombre" name="nompro" value="${productos1.getNom_prod()}"></td>
				<td><input type="text" class="iva1" value="${Iva1.getIva_com()}"></td>
				<td><input type="text" class="pre1" id="preci1" name="precio1" value="${productos1.getPre_ven()}"></td>
			</tr>
			
			<tr>
				<td><input type="text" name="codigo2" value="${productos2.getCod_pro()}"></td>
				<td><input type="number" class="cantidad2" id="canti2" name="cant2" value="${canti3 }"></td>
				<td><input type="submit" name="buscar2" value="Confirmar"></td>
				<td><input type="text" class="nombre" name="nompro" value="${productos2.getNom_prod()}"></td>
				<td><input type="text" class="iva2" value="${Iva2.getIva_com()}"></td>
				<td><input type="text" class="pre2" id="preci2" name="precio2" value="${productos2.getPre_ven()}"></td>
				
			</tr>			
				<tr>
				<th></th>
				<td><input type="text" name="canttot" value="${cantot }" placeholder="Cantidad Total"></td>
				</tr>
				
				
				<tr>
				<th>TOTAL A PAGAR</th>
				<td><input type="text" name="Total" value="${Total}"></td>
				
				<th>TOTAL IVA</th>
				<td><input type="text" name="IVAS" value="${IVAS }"></td>
				
				<th>TOTAL SIN IVA</th>
				<td><input type="text" name="sinIv" value="${sinIv }" ></td>
				</tr>
		
				<tr><td class="ult" colspan="5"><input type="submit" name="calcular" value="Calcular Venta"></td></tr>
				<tr><td class="ult" colspan="4"><input type="submit" name="total" value="Enviar Venta"></td></tr>
				<tr><td class="res" colspan="3"><input type="submit" name="reset" value="Reset"></td></tr>
		</table>	
		
		
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
		    	<p>Síguenos en nuestras redes sociales</p>
		    	<div class="redesSociales">
			    	<a><img alt="Facebook" src="imgs/facebook.svg"></a>
			    	<a><img alt="Instagram" src="imgs/instagram.svg"></a>
			    	<a><img alt="Twitter" src="imgs/twitter.svg"></a>
		    	</div>
		    	<div class="copyright">
		    		<p><small>Copyright &copy 2021. All Rights Reserved</small></p>
		    	</div>
	    	</div>
	    </div> -->
	   	
	</div>

</body>
</html>
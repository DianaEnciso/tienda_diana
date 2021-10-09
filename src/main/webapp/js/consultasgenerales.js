$(document).ready(function(){
	alert("entró al .js");
	
	$('.btnconsulta_uno').on('click',function(){
		
		alert("consulta uno")
		consultausuario();
		
	});
	
	
	
	$('.btnconsulta_dos').on('click',function(){
		
				alert('consulta dos ')
		consultacliente();
	});
	
	
	
	function consultausuario(){
		alert("en el metodo")
		alert("entro")
	
	$.ajax({		
				
	url: "ReporUsu", 
	type: "POST",
	/*dataType: 'json',*/ 
	
	sucess: function( lis )
	{
		console.log("en el console");
		console.log(lis);	
		var tabla=document.getElementById('table');
		console.log(tabla);
		tabla.innerHTML='';
		tabla.innerHTML+=`<tr>
		
							<th>Cedula</th>
							<th>Email</th>
							<th>Nombre</th>
							<th>Clave</th>
							<th>Usuario</th>
							
						</tr>`;
						
		for(let i  of lis)
		{
			tabla.innerHTML+=`<tr>
			
							<td>${i.cedula_usuario}</td>
							<td>${i.email_usuario}</td>
							<td>${i.nombre_usuario}</td>
							<td>${i.password}</td>
							<td>${i.usuario}</td>
						
						</tr>`;
			
		}
							
		}
		});
		}

	function consultacliente(){
		alert('entra a consulta cliente')
		
	$.ajax({
		
		
		url: 'Reporteclientes',
		type: 'POST',
		dataType: 'json',
		
		success: function(lista)
		{
			console.log(lista);
			var tabla2=document.getElementById('table');
			console.log(tabla2);
			tabla2.innerHTML='';
			tabla2.innerHTML+=`<tr>
			
							<th>Cedula</th>
							<th>Direccion</th>
							<th>Email</th>
							<th>Nombre</th>
							<th>Telefono</th>
			</tr>`;
			
			for(let i of lista)
			{
				tabla2.innerHTML+=`<tr>
				
									<td>${i.cedula_cliente}</td>
									<td>${i.direccion_cliente}</td>
									<td>${i.email_cliente}</td>
									<td>${i.nombre_cliente}</td>
									<td>${i.telefono_cliente}</td>
								
								</tr>`;
				
				
			}
		}
		
		});
		}
		});
	


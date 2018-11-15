<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">
		<script type="text/javascript" src="js/solid.js" ></script>
		<script type="text/javascript" src="js/fontawesome.js" ></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="/includes/sidemenu.jsp" />
			<div class="content">
				<jsp:include page="/includes/header.jsp" />
				<div id="homecont">
					<div id="home" class="cadcont">
						<h2 class="ola"> Ol� <%= " "+session.getAttribute( "usuario" ) %> </h2>
						<p> 
							Em lingu�stica, a no��o de texto � ampla e ainda aberta a uma
							defini��o mais precisa. Grosso modo, pode ser entendido como
							manifesta��o lingu�stica das ideias de um autor, que ser�o
							interpretadas pelo leitor de acordo com seus conhecimentos
							lingu�sticos e culturais. Seu tamanho � vari�vel.
						</p>
						<jsp:include page="/includes/modal.jsp" />
						<button class="btn btn-primary" data-toggle="modal" data-target=".modalCaminhoes">Organizar Entregas</button>  
						<jsp:include page="/ui.cadastro/alterarMotorista.jsp" />
						<button class="btn btn-primary" data-toggle="modal" data-target=".modalMOT">Organizar MOT</button>  
					</div>
					
					<div class="card">
						<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste3.jpg" %> alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Nome do Motorista</h5>
							<p class="card-text">Aqui vai algumas informa��es sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de ve�culo tbm</p>
							<a href="#" class="btn btn-primary">Visualizar</a>
						</div>
					</div>
					
					<div class="card">
						<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste.jpg" %> alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Nome do Motorista</h5>
							<p class="card-text">Aqui vai algumas informa��es sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de ve�culo tbm</p>
							<a href="#" class="btn btn-primary">Visualizar</a>
						</div>
					</div>

					<div class="card">
						<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste2.jpg" %> alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Nome do Ve�culo</h5>
							<p class="card-text">Aqui vai algumas informa��es sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de ve�culo tbm</p>
							<a href="#" class="btn btn-primary">Visualizar</a>
						</div>
					</div>
															
				</div>
			</div>
			<div class="footer">
				<jsp:include page="/includes/footer.html" />
			</div>
		</div>
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>   
		<script type="text/javascript" src="js/popper-1-14-3.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/scrollercdn.js"></script>
		<script type="text/javascript" src="js/ui.js"></script>
		<script type="text/javascript">
		
		
		
			// 			$(function(){
			<%-- 				<% if(session.getAttribute( "usuario" ) == null)response.sendRedirect( AppConsts.CAMINHO+"/index.jsp" );%> --%>
			// 			})			
			// 			$("#btnsair").click(function(){
			<%-- 				<% session.setAttribute( "usuario", null ); %> --%>
			// 			});
					
		</script>
	</body>
</html>
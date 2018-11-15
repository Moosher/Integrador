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
						<h2 class="ola"> Olá <%= " "+session.getAttribute( "usuario" ) %> </h2>
						<p> 
							Em linguística, a noção de texto é ampla e ainda aberta a uma
							definição mais precisa. Grosso modo, pode ser entendido como
							manifestação linguística das ideias de um autor, que serão
							interpretadas pelo leitor de acordo com seus conhecimentos
							linguísticos e culturais. Seu tamanho é variável.
						</p>
						<jsp:include page="/includes/modal.jsp" />
						<button class="btn btn-primary" data-toggle="modal" data-target=".modalCaminhoes">Organizar Entregas</button>  
						<jsp:include page="/ui.cadastro/alterarMotorista.jsp" />
						<button class="btn btn-primary" data-toggle="modal" data-target=".modalMOT">Organizar MOT</button>  
					</div>
				
					<div class="sliderCont">
						<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
						  <ol class="carousel-indicators">
						    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						  </ol>
						  <div class="carousel-inner">
						    <div class="carousel-item active">
						      <img class="d-block w-100" src=<%=AppConsts.CAMINHO+ "/img/teste5.jpg" %> alt="First slide">
						    </div>
						    <div class="carousel-item">
						      <img class="d-block w-100" src=<%=AppConsts.CAMINHO+ "/img/teste4.jpg" %> alt="Second slide">
						    </div>
						  </div>
						  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
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
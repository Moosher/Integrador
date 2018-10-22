<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Conclu�do</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">
		<script type="text/javascript" src="../js/solid.js" ></script>
		<script type="text/javascript" src="../js/fontawesome.js" ></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../includes/sidemenu.jsp" />
			<div class="content">
				<jsp:include page="../includes/header.jsp" />
				<div class="container cadcont">
					<div class="form-group">
						<h3>Cadastro de Objeto para Entrega Finalizado</h3>
						<div id="recibo">
							<h4>Transportadora Entrega R�pida</h4>
							<h4>Recibo</h4>
							<ul>
								<li>C�digo verificador:<%=" " + request.getParameter( "id" ) %></li>
								<li>Nome do remetente:<%=" " + request.getParameter("nomeR") %></li>
								<li>Endere�o do remetente: <%=" " + request.getParameter("enderecoR") %></li>
								<li>Nome do destinat�rio:<%=" " + request.getParameter("nomeD") %></li>
								<li>Endere�o do destinat�rio:<%=" " + request.getParameter("enderecoD") %></li>
								<li>Data de dep�sito do objeto na empresa:<%=" " + request.getParameter("dataDeposito") %></li>
								<li>Peso do objeto:<%=" " + request.getParameter("peso") %></li>
							</ul>
						</div><br/>
						<p>O recibo sera impresso imediatamente ap�s o fim da opera��o.</p>
						<a class="btn btn-primary" href=<%=AppConsts.CAMINHO +"/home.jsp" %>>Finalizar</a>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<jsp:include page="../includes/footer.html" />
		</div>		
		<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>   
		<script type="text/javascript" src="../js/popper-1-14-3.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/scrollercdn.js"></script>
		<script type="text/javascript" src="../js/ui.js"></script>
	</body>
</html>
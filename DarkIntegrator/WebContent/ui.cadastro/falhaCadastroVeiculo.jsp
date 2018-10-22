<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Falha ao Cadastrar Veículo</title>
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
				<div class="container smcont">
					<div class="form-group">
						<h3>Falha ao Cadastrar Veículo</h3>
						<br/>
						<p class="alert alert-danger">O veículo escolhido não pode ser vinculado ao motorista solicitado. Possíveis motivos: </p>
						<ul>
							<li>O tipo de CNH do motorista não está de acordo com o veículo.</li>
							<li>O veículo ja foi entregue a outro motorista.</li>
							<li>O motorista ja está cadastrado com outro veículo.</li>
						</ul><br/>
						<p>Verifique as condições citadas acima e tente novamente.</p>
						<a class="btn btn-danger" href=<%=AppConsts.CAMINHO + "/home.jsp" %>>Voltar</a>
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
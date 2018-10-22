<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Incorreto</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">
	</head>
	<body>
		<div class="container smcont">
			<div class="form-group">
				<h3>Erro ao cadastrar objeto</h3>
				<br/>
				<p class="alert alert-danger">Erro</p>
				<a class="btn btn-danger" href=<%=AppConsts.CAMINHO %>>Voltar</a>
			</div>
		</div>
		<div class="footer">
			<jsp:include page="/includes/footer.html" />
		</div>
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>   
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</body>
</html>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Concluído</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">		
	</head>
	<body>
		<div class="container smcont">
			<div class="form-group">
				<h2 class="ola">
					Olá	<%=request.getParameter("nome") %>
				</h2>
				<p class="alert alert-success">
					Seu cadastro foi realizado com sucesso, basta confirmar as seguintes
					informações:
				</p>
				<ul>
					<li>Nome(Login): <%=request.getParameter("nome") %></li>
					<li>Senha: <%=request.getParameter("senha") %></li>
				</ul>
				<a class="btn btn-danger" href=<%=AppConsts.CAMINHO %>>Voltar</a>
			</div>
		</div>
		<div class="footer">
			<jsp:include page="/includes/footer.html" />
		</div>
	</body>
</html>
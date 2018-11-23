<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">
	</head>
	<body>
		<div class="container smcont">
			<div class="form-group">
				<h3>Cadastro</h3>
				<br/>
				<form action=<%=AppConsts.CAMINHO+"/CadastroLoginServlet" %> method="post">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">Login</span>
						</div>
						<input type="text" placeholder="login" name="login" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">Senha</span>
						</div>
						<input type="password" placeholder="Senha" name="senha" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
					</div>
			        <div class="col-auto my-1" style="padding-left: 0px;">
		      			<div class="custom-control custom-checkbox mr-sm-2" >
		       				 <input type="checkbox" name="checkbanco" class="custom-control-input" id="banco" checked>
		       				 <label class="custom-control-label" for="banco">Deseja usar persistência em banco de dados?</label>
		      			</div>
		    		</div>
					<button class="btn btn-primary" type="submit">Enviar</button>
					<a class="btn btn-danger" href=<%=AppConsts.CAMINHO %>>Voltar</a>
				</form>
			</div>
		</div>
		<div class="footer">
			<jsp:include page="/includes/footer.html" />
		</div>		
	</body>
</html>
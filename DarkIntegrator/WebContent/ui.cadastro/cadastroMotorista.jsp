<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Motorista</title>
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
						<h3>Cadastro de Motorista</h3>
						<br/>
						<form action=<%=AppConsts.CAMINHO+"/CadastroMotoristaServlet" %> method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Nome Completo</span>
								</div>
								<input placeholder="Nome" name="nome" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Endereço</span>
								</div>
								<input placeholder="Endereço" name="endereco" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Data de Nascimento</span>
								</div>
								<input placeholder="Data de Nascimento" name="dataNasc" type="date" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Tipo CNH</span>
								</div>
								<select class="form-control" name="tipoCNH">
									<option value="B">Tipo B</option>	
									<option value="C">Tipo C</option>	
								</select>
							</div>						
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Número CNH</span>
								</div>
								<input placeholder="N. CNH" name="CNH" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<button class="btn btn-primary" type="submit">Finalizar</button>
							<a class="btn btn-danger" href=<%=AppConsts.CAMINHO + "/home.jsp" %>>Voltar</a>
						</form>
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
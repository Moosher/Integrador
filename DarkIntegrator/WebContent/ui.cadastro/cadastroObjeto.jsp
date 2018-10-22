<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Objeto</title>
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
						<h3>Cadastro de Objeto para Entrega</h3>
						<br/>
						<form action=<%=AppConsts.CAMINHO+"/CadastroObjetoServlet" %>	method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Nome do Remetente</span>
								</div>
								<input placeholder="Nome" name="nomeRemetente" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Endereço Remetente</span>
								</div>
								<input placeholder="Endereço" name="enderecoRemetente" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Nome do Destinatário</span>
								</div>
								<input placeholder="Nome" name="nomeDestinatario" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Endereço Destinatário</span>
								</div>
								<input placeholder="Endereço" name="enderecoDestinatario" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Peso do Objeto</span>
								</div>
								<input id="peso" placeholder="Peso" name="peso" type="number" step="0.01" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Código Verificador</span>
								</div>
								<input id="codloc" placeholder="Código" name="cod" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
							</div>
							<br/>
							<p>Caso o código verificador não seja informado, iremos gerar um automáticamente.</p>
							<p>Para sua segurança e praticidade, recomendamos que deixe o sistema gerar o código.</p>
							<button class="btn btn-primary" id="btnsbt" type="submit">Finalizar</button>
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
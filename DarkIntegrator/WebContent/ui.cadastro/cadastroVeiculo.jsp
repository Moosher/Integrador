<%@page import="model.dao.ModeloDao"%>
<%@page import="model.dao.MotoristaDao"%>
<%@page import="model.dao.VeiculoDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="model.Modelo"%>
<%@page import="model.Motorista"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	VeiculoDao veiculos = DaoFactory.getDaoFactory().getVeiculoDao();
	MotoristaDao motoristas = DaoFactory.getDaoFactory().getMotoristaDao();
	ModeloDao modelos = DaoFactory.getDaoFactory().getModeloDao();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Veículo</title>
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
						<h3>Cadastro de Veículo</h3>
						<br/>
						<form action=<%=AppConsts.CAMINHO+"/CadastroVeiculoServlet" %> method="post">						
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Marca do Veículo</span>
								</div>
								<input placeholder="Marca" name="marca" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>					
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Modelo do Veículo</span>
								</div>
								<select class="form-control" id="cmbmodelo" name="modelo">
									<%
										int j = 0;
										for(Modelo modelo: modelos.getModeloList()){
											out.println("<option value="+j+">"+modelo.getNome()+"</option>");
											j++;
										}								
									
									%>
								</select>
							</div>					
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Ano do Veículo</span>
								</div>
								<input placeholder="Ano" name="ano" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Placa</span>
								</div>
								<input placeholder="Placa" name="placa" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" required>
							</div>
														
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Motorista</span>
								</div>
								<select class="form-control" name="motorista">
									<option value="N">Vincular motorista posteriormente</option>
									<%
									
										boolean disponivel;
										int i = 0;
										for( Motorista motorista : motoristas.getMotoristaList()){
											disponivel = motorista.isDisponivel();
											if(disponivel){
												out.println("<option value="+i+">"+motorista.getNome()+", CHN tipo "+motorista.getTipoCNH()+"</option>");
											}
											i++;
										}
									%>
								</select>
							</div><br/>
							<p>Pelas normas do Detran, são necessarias os seguintes tipo de CNH para os veículos disponíveis:</p>
							<ul>
								<li>Carteira tipo B: Van</li>
								<li>Carteira tipo C: Van, caminhão baú e carreta</li>
							</ul>			
							<p>Caso o motorista cadastrado não se encaixe no tipo de CNH necessário, o cadastro será cancelado.</p>
							<input type="hidden" name="capacidade" id="capacidade">
							<input type="hidden" name="prioridade" id="prioridade">
							<button id="subveiculo" class="btn btn-primary" type="submit">Finalizar</button>
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
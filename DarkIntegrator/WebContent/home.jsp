<%@page import="model.Motorista"%>
<%@page import="model.Objeto"%>
<%@page import="model.Veiculo"%>
<%@page import="java.util.Random"%>
<%@page import="model.dao.VeiculoDao"%>
<%@page import="model.dao.MotoristaDao"%>
<%@page import="model.dao.ObjetoDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

	<%		
		ObjetoDao objetos = DaoFactory.getDaoFactory().getObjetoDao();
		MotoristaDao motoristas = DaoFactory.getDaoFactory().getMotoristaDao();
		VeiculoDao veiculos = DaoFactory.getDaoFactory().getVeiculoDao();
		
		Objeto objeto = null;
		Motorista motorista = null;
		Veiculo veiculo = null;
		Random randNumber = new Random();
		int indexObjeto = 0;
		int indexMotorista = 0;
		int indexVeiculo = 0;
		if( objetos.getObjetoList().size() > 0 || motoristas.getMotoristaList().size() > 0 || veiculos.getVeiculoList().size() > 0){
		
			indexObjeto = randNumber.nextInt(objetos.getObjetoList().size()) + 0;
			indexMotorista = randNumber.nextInt(motoristas.getMotoristaList().size()) + 0;
			indexVeiculo = randNumber.nextInt(veiculos.getVeiculoList().size()) + 0;
	
		objeto = objetos.getObjetoList().get( indexObjeto );
		motorista = motoristas.getMotoristaList().get( indexMotorista );
		veiculo = veiculos.getVeiculoList().get( indexVeiculo );
		}
		
	%>
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
				
				
					<%if (objeto != null || motorista == null || veiculo == null){%>				
					<div class="cardCont">
					
					<% if (objeto != null){%>
						<div class="card">
							<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste3.jpg" %> alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title"><%= objeto.getCodigoLocalizador(  )%></h5>
								<p class="card-text">Aqui vai algumas informações sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de veículo tbm</p>
								<a href="#" class="btn btn-primary">Visualizar</a>
							</div>
						</div>
						
					<%} if (motorista != null){%>
						<div class="card">
							<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste.jpg" %> alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title"><%= motorista.getNome(  ) %></h5>
								<p class="card-text">Aqui vai algumas informações sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de veículo tbm</p>
								<a href="#" class="btn btn-primary">Visualizar</a>
							</div>
						</div>
						
					<%} if (veiculo != null){%>
						<div class="card">
							<img class="card-img-top" src=<%=AppConsts.CAMINHO+ "/img/teste2.jpg" %> alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title"><%= veiculo.getModelo(  ).getNome(  ) %></h5>
								<p class="card-text">Aqui vai algumas informações sobreo  motorista e tal, ja que precisamos popular essa area do sistema, da pra colocar uns card de veículo tbm</p>
								<a href="#" class="btn btn-primary">Visualizar</a>
							</div>
						</div>
						<%} %>
					</div>
					<%} %>
															
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
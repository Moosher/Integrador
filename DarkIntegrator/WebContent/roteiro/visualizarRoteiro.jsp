<%@page import="model.Veiculo"%>
<%@page import="model.dao.VeiculoDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="model.dao.RoteiroDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Objeto"%>
<%@page import="model.Roteiro"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	RoteiroDao roteiros = DaoFactory.getDaoFactory().getRoteiroDao();
	VeiculoDao veiculos = DaoFactory.getDaoFactory().getVeiculoDao();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Roteiro do Dia</title>
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
						<h3>Retorno</h3>
						<%
							for(Veiculo veiculo : veiculos.getVeiculoList()){
								if(veiculo.getId().equals(request.getParameter("veiculo"))){
									out.println("<h4 class=ola>"+veiculo.getModelo().getNome() +"  |  "+ veiculo.getMotorista().getNome()+"</h4>");
									break;
								}
							}						
						%>
						<br/>
						<form action=<%=AppConsts.CAMINHO+"/RetornoRoteiroServlet" %>	method="post">					
							<% 
								int i = 0;
								for(Objeto objeto : roteiros.getObjetoRoteiroList(request.getParameter( "id" ))){
									out.println("<ul style='margin-top:10px; padding:0px;' class=list-unstyled id=alt"+i+">");
									out.println("<li class=list-unstyled>");
									
									out.println("<table style=width:100% >");
									
									out.println("<tr id=trlabels >");						
									out.println("<td>Código Loc.</td>");
									out.println("<td>Destinatário</td>");
									out.println("<td>Endereço</td>");
									out.println("<td>Data de Depósito</td>");							
									out.println("</tr>");
									
									out.println("<tr>");							
									out.println("<td>");						
									out.println("<input class=form-control name=codloc value="+objeto.getCodigoLocalizador()+" disabled />");
									out.println("</td>");						
									out.println("<td>");						
									out.println("<input class=form-control name=nomeDestinatario value="+objeto.getNomeD()+" disabled />");
									out.println("</td>");						
									out.println("<td>");						
									out.println("<input class=form-control name=enderecoDestinatario value="+objeto.getEnderecoD()+" disabled />");
									out.println("</td>");						
									out.println("<td>");						
									out.println("<input class=form-control name=data value="+objeto.getDataDeposito()+" disabled />");
									out.println("</td>");						
									out.println("<tr>");
									
									out.println("</table>");
									
									out.println("<div class='input-group' >");
									out.println("<div class='input-group-prepend' >");
									out.println("<label class='input-group-text'>Status</label>");
									out.println("</div>");
									
									out.println("<select class=custom-select name=motorista>");
									out.println("<option value=ausente>Não Entregue</option>");
									out.println("<option value=entregue>Entregue</option>");						
									out.println("</select>");									
									out.println("</div>");
									
									out.println("</li>");
									out.println("</ul>");
									out.println("<hr class=half-rule />");

									i++;
								}
							%>	
																		
							<button class="btn btn-primary " id="btnsbt" type="submit">Finalizar</button>
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
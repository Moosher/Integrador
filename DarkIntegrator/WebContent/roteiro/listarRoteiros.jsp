<%@page import="model.dao.RoteiroDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="model.Roteiro"%>
<%@page import="model.dao.arquivo.FileControl"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
	RoteiroDao roteiros = DaoFactory.getDaoFactory().getRoteiroDao();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Selecione um Roteiro</title>
		<link href=<%=AppConsts.CAMINHO+ "/img/favicon.ico" %> rel="shortcut icon" type="image/x-icon" />
		<link href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal" rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/bootstrap.css" %> rel="stylesheet">
		<link href=<%=AppConsts.CAMINHO+ "/css/ui.css" %> rel="stylesheet">
		<script type="text/javascript" src="../js/solid.js" ></script>
		<script type="text/javascript" src="../js/fontawesome.js" ></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="/includes/sidemenu.jsp" />
			<div class="content">
				<jsp:include page="/includes/header.jsp" />
				<div class="container cadcont">				
						<h3>Selecione um Roteiro</h3>	
						<br/>
						
					<%
						int i = 0;
						for(Roteiro roteiro :roteiros.getRoteiroList()){
							if(!roteiro.getObjetosRoteiro().isEmpty()){
							
								
								out.println("<ul style='margin-top:10px; padding:0px;' class=list-unstyled id=alt"+i+">");
								out.println("<li class=list-unstyled>");
								
								out.println("<table style=width:100% >");
								
								out.println("<tr id=trlabels >");						
								out.println("<td>Motorista</td>");
								out.println("<td>CNH</td>");
								out.println("<td>Veiculo</td>");
								out.println("<td>Carga</td>");							
								out.println("<td>Data do Roteiro</td>");
								out.println("</tr>");
								
								
								out.println("<tr>");							
								out.println("<td>");						
								out.println("<input class=form-control name=nomeMotorista value="+roteiro.getVeiculo().getMotorista().getNome()+" disabled />");
								out.println("</td>");						
								out.println("<td>");						
								out.println("<input class=form-control name=cnh value="+roteiro.getVeiculo().getMotorista().getCNH()+" disabled />");
								out.println("</td>");						
								out.println("<td>");						
								out.println("<input class=form-control name=modelo value="+roteiro.getVeiculo().getModelo().getNome()+" disabled />");
								out.println("</td>");						
								out.println("<td>");						
								out.println("<input class=form-control name=carga value="+ roteiros.getObjetoRoteiroList(roteiro.getId()).size() +" disabled />");
								out.println("</td>");						
								out.println("<td>");						
								out.println("<input class=form-control name=data value='"+roteiro.getData()+"' disabled />");
								out.println("</td>");						
								out.println("<tr>");
								
								out.println("</table>");
								
								
								out.println("<a  id=btnmodal class='btn btn-secondary btn-sm btn-block' href='"+ AppConsts.CAMINHO + "/roteiro/visualizarRoteiro.jsp?id="+ roteiro.getId() + "&veiculo="+roteiro.getVeiculo().getId()+"' >Entrar</a>");
						
								out.println("</li>");
								out.println("</ul>");
								out.println("<hr class=half-rule />");
								out.println("<br/>");
	
								i++;
							}
						}
					%>						
					</div>
			</div>
			<div class="footer">
				<jsp:include page="/includes/footer.html" />
			</div>
		</div>
		<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>   
		<script type="text/javascript" src="../js/popper-1-14-3.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/scrollercdn.js"></script>
		<script type="text/javascript" src="../js/ui.js"></script>
	</body>
</html>
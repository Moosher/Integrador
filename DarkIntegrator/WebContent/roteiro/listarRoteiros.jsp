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
				<div id="homecont">				
					<div id="home" class="container">
						<h3>Selecione um Roteiro</h3>	
						<table class="table table-bordered">
							<thead>
								<tr>
									<th class="thbtn">Acessar</th>
									<th>Detalhes</th>
									<th>Data</th>
								</tr>
							</thead>
							<tbody>
								<%
									int i = 0;
									for(Roteiro roteiro :roteiros.getRoteiroList()){
										if(!roteiro.getObjetosRoteiro().isEmpty()){
											out.println("<tr>");											
											out.println("<td><a class=btn btn-primary href="+ AppConsts.CAMINHO + "/roteiro/visualizarRoteiro.jsp?id="+ i +">Acesse</a></td>");											
											out.println("<td>"+ roteiro.toString() +"</td>");											
											out.println("<td>"+ roteiro.getData() +"</td>");											
											out.println("</tr>");
											
										}
											i++;
										
									}	
								%>
							</tbody>
						</table>
					</div>
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
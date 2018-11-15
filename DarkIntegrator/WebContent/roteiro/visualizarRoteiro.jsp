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
						<br/>
						<form action=<%=AppConsts.CAMINHO+"/RetornoRoteiroServlet" %>	method="post">					
							<% 
									
								int i = 0;
								for(Objeto objeto : roteiros.getObjetoRoteiroList(request.getParameter( "id" ))){
										
									out.println("<div class=form-group form-check>");
									out.println("<input name=param"+i+" type=checkbox class=form-check-input>"+objeto.getCodigoLocalizador());
									out.println("</div>");
								}
						
 							%>
														
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
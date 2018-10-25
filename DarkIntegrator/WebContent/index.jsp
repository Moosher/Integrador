<%@page import="model.dao.arquivo.FileControl"%>
<%@page import="resources.AppConsts"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	ResourceBundle rb = ResourceBundle.getBundle("/resources/ResourceBundle");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href=<%=AppConsts.CAMINHO + "/img/favicon.ico"%>
	rel="shortcut icon" type="image/x-icon" />
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Inline|Tajawal"
	rel="stylesheet">
<link href=<%=AppConsts.CAMINHO + "/css/bootstrap.css"%>
	rel="stylesheet">
<link href=<%=AppConsts.CAMINHO + "/css/ui.css"%> rel="stylesheet">
</head>
<body>
	<div class="container smcont">
		<h2><%=rb.getString("msg.login")%></h2>
		<br />
		<form action=<%=AppConsts.CAMINHO + "/ReceiveServlet"%> method="post">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-default">
						<%=rb.getString("lbl.login")%>
					</span>
				</div>
				<input type="text" placeholder=<%=rb.getString("lbl.login")%> name="login" type="text"
					class="form-control" aria-label="Default"
					aria-describedby="inputGroup-sizing-default" required>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-default">
						<%=rb.getString("lbl.senha")%>
					</span>
				</div>
				<input type="password" placeholder=<%=rb.getString("lbl.senha")%> name="senha" type="text"
					class="form-control" aria-label="Default"
					aria-describedby="inputGroup-sizing-default" required>
			</div>
		    
	        <div class="col-auto my-1" style="padding-left: 0px;">
      			<div class="custom-control custom-checkbox mr-sm-2" >
       				 <input type="checkbox" name="checkbanco" class="custom-control-input" id="banco" >
       				 <label class="custom-control-label" for="banco">Deseja usar persistência em banco de dados?</label>
      			</div>
    		</div>
			
			<button type="submit" class="btn btn-secondary"><%=rb.getString("btn.entrar")%></button>
			<a class="btn btn-primary"
				href=<%=AppConsts.CAMINHO + "/cadastroUsuario.jsp"%>><%=rb.getString("btn.cadastrar")%></a>
		</form>
	</div>
	<div class="footer">
		<jsp:include page="/includes/footer.html" />
	</div>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
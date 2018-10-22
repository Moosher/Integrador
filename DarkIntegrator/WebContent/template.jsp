<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title></title>
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
				<div class="container smcont">
				<!-- aquiiiiiii -->
				</div>
			</div>
		</div>
		<div class="footer">
			<jsp:include page="/includes/footer.html" />
		</div>			
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>   
		<script type="text/javascript" src="js/popper-1-14-3.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/scrollercdn.js"></script>
		<script type="text/javascript" src="js/ui.js"></script>
	</body>
</html>
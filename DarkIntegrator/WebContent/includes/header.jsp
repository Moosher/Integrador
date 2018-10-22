<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<button type="button" id="sidebarCollapse" class="btn btn-primary">
					<i class="fas fa-align-justify"></i>                    
				</button>
				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item active">
						<a id="btnsair" class="btn btn-danger" href=<%=AppConsts.CAMINHO %>>Sair</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</header>

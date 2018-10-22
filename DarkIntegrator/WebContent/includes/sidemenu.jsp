<%@page import="java.util.ResourceBundle"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>   
<nav id="sidebar">

	<div class="sidebar-header">
		<h3 id="menu"><i class="fas fa-align-left"></i> MENU</h3>
	</div>
	<div id="empnome"><p>Transportadora Entrega Rápida</p></div>
	<ul class="list-unstyled components">
		
		<li><a href=<%=AppConsts.CAMINHO + "/home.jsp" %>><i class="fa fa-home"></i>Home</a> 
		<li>
			<a href="#cadastroSub" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle dropA"><i class="fa fa-address-book"></i>Cadastro</a>
			<ul class="collapse list-unstyled dropC" id="cadastroSub">
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/cadastroObjeto.jsp" %>><i class="fa fa-book-open"></i>Objeto</a>
				</li>
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/cadastroMotorista.jsp" %>><i class="fa fa-book-open"></i>Motorista</a>
				</li>
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/cadastroVeiculo.jsp" %>><i class="fa fa-book-open"></i>Veículo</a>
				</li>
			</ul>
		</li>
		<li >
			<a href="#roteiro" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle dropA"><i class="fa fa-chevron-circle-right"></i>Roteiro</a>
			<ul class="collapse list-unstyled dropC" id="roteiro">
				<li>
					<a href=<%= AppConsts.CAMINHO + "/CadastroRoteiroServlet" %>><i class="fa fa-truck-loading"></i>Gerar Roteiro</a>
				</li>
				<li>
					<a href=<%= AppConsts.CAMINHO + "/roteiro/listarRoteiros.jsp" %>><i class="fa fa-eye"></i>Visualizar Roteiros</a>
				</li>
			</ul>
		</li>
		<li>
			<a href="#relatorio" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle dropA">Relatório</a>
			<ul class="collapse list-unstyled dropC" id="relatorio">
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/relatorio/relatorioObjeto.jsp" %>>Objetos</a>
				</li>
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/relatorio/relatorioMotorista.jsp" %>>Motorista</a>
				</li>
				<li>
					<a href=<%=AppConsts.CAMINHO + "/ui.cadastro/relatorio/relatorioVeiculo.jsp" %>>Veículo</a>
				</li>
			</ul>
		</li>
	</ul>
</nav>

<%@page import="model.Veiculo"%>
<%@page import="model.dao.VeiculoDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	VeiculoDao veiculos = DaoFactory.getDaoFactory().getVeiculoDao();
%>
<div class="modal fade modalMOT" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="containerModal">
				<h3> Alterar Dados de Veículo</h3>

						<%
						int i = 0;
						for(Veiculo veiculo : veiculos.getVeiculoList()){
							out.println("<form id=formmodal action="+AppConsts.CAMINHO +"/RetornoRoteiroServlet method=post>");
							out.println("<a href=#alt"+i+" data-toggle=collapse aria-expanded=false class='btn btn-primary' >"+veiculo.getMotorista().getNome(  )+"</a>");
							out.println("<br/>");
							
							out.println("<ul class=collapse list-unstyled id=alt"+i+">");
							out.println("<li>");

							out.println("<input name=marca value="+veiculo.getMarca(  )+" />");
							out.println("<input name=ano value="+veiculo.getAno(  )+" />");
							out.println("<input name=placa value="+veiculo.getPlaca(  )+" />");
							out.println("<button type=submit id=btnmodal class="+"btn btn-secondary"+" >Enviar</button>");
							
							out.println("</li>");
							out.println("</ul>");
							out.println("</form>");

							i++;
						}
						
						
						
						%>						
						
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Voltar</button>	
				</div>
			</div>
		</div>
	</div>
</div>
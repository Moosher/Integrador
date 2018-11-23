<%@page import="org.apache.tomcat.util.codec.binary.StringUtils"%>
<%@page import="model.dao.MotoristaDao"%>
<%@page import="model.Motorista"%>
<%@page import="model.Veiculo"%>
<%@page import="model.dao.VeiculoDao"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="resources.AppConsts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	VeiculoDao veiculos = DaoFactory.getDaoFactory().getVeiculoDao();
	MotoristaDao motoristas = DaoFactory.getDaoFactory().getMotoristaDao();
	%>
<div class="modal fade modalMOT" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="containerModal">
				<h3>Alterar Motorista</h3>
				<br/>

						<%
						int i = 0;
						for(Veiculo veiculo : veiculos.getVeiculoList()){
							
							String testeNullNome = "Motorista não alocado";
							String testeNullCNH = "";
							if(veiculo.getMotorista() != null){
								testeNullNome = veiculo.getMotorista().getNome();
								testeNullCNH = ", CHN tipo "+veiculo.getMotorista().getTipoCNH();
							}
							
							out.println("<form id=formmodal action='"+AppConsts.CAMINHO +"/CadastroVeiculoServlet' method='get'>");
							out.println("<a style='width:100%' href=#alt"+i+" data-toggle=collapse aria-expanded=false class='btn btn-primary btn-lg btn-block ola' >"+ testeNullNome +"</a>");
							
							out.println("<ul style='margin-top:10px; padding:0px;' class=collapse list-unstyled id=alt"+i+">");
							out.println("<li class=list-unstyled>");
							
							out.println("<table style=width:100% >");
							
							out.println("<tr id=trlabels >");						
							out.println("<td>Marca</td>");
							out.println("<td>Modelo</td>");
							out.println("<td>Ano</td>");
							out.println("<td>Placa</td>");							
							out.println("</tr>");
							
							out.println("<tr>");							
							out.println("<td>");						
							out.println("<input class=form-control name=marca value="+veiculo.getMarca()+" disabled />");
							out.println("</td>");						
							out.println("<td>");						
							out.println("<input class=form-control name=modelo value="+veiculo.getModelo().getNome()+" disabled />");
							out.println("</td>");						
							out.println("<td>");						
							out.println("<input class=form-control name=ano value="+veiculo.getAno()+" disabled />");
							out.println("</td>");						
							out.println("<td>");						
							out.println("<input class=form-control name=placa value="+veiculo.getPlaca()+" disabled />");
							out.println("</td>");						
							out.println("<tr>");
							
							out.println("</table>");
							
							out.println("<div class='input-group' >");
							out.println("<div class='input-group-prepend' >");
							out.println("<label class='input-group-text'>Motorista</label>");
							out.println("</div>");
							
							out.println("<select class=custom-select name=motoristaIndex>");
							out.println("<option>"+testeNullNome + testeNullCNH+"</option>");
							int j = 0;
							for( Motorista motorista : motoristas.getMotoristaList()){
								if(motorista.isDisponivel()){
									out.println("<option value="+j+">"+motorista.getNome()+", CHN tipo "+motorista.getTipoCNH()+"</option>");
								}
								j++;
							}
							if(!testeNullNome.equals( "Motorista não alocado" )){
								out.println("<option value=desalocar>Desalocar motorista</option>");
								
							}
							out.println("</select>");
							
							out.println("<div class='input-group-append'>");
							out.println("<button type=submit id=btnmodal class='btn btn-secondary' >Enviar</button>");
							out.println("</div>");
							out.println("</div>");
							
							out.println("</li>");
							out.println("</ul>");
							out.println("<input type=hidden name=veiculoIndex value="+i+" />");
							out.println("</form>");
							out.println("<hr class=half-rule />");

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
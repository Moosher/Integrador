<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<div class="modal fade modalCaminhoes" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="containerModal">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="thbtn">Configuração</th>
							<th>Veículo</th>
							<th>Motorista</th>
							<th>Disponibilidade</th>
						</tr>
					</thead>
					<!-- TODO CONTEUDO DO TBODY SERA GERADO DINAMICAMENTEM, ISSO É UM EXEMPLO -->
					<tbody>
						<tr>
							<td><a href="home.jsp" class="btn btn-primary">Acessar</a></td>
							<td>caminhão</td>
							<td>um asiático</td>
							<td>disponibilidade de 3s entre os compromissos</td>
						</tr>
						<tr>
							<td><a href="home.jsp" class="btn btn-primary">Acessar</a></td>
							<td>van</td>
							<td>um velho</td>
							<td>o dia todo</td>
						</tr>
						<tr>
							<td><a href="home.jsp" class="btn btn-primary">Acessar</a></td>
							<td>carreta</td>
							<td>meu pai</td>
							<td>nunca nem vi</td>
						</tr>
					</tbody>
				</table>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Voltar</button>	
				</div>
			</div>
		</div>
	</div>
</div>
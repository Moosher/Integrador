package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Modelo;
import model.Motorista;
import model.Veiculo;
import model.dao.DaoFactory;
import model.dao.MotoristaDao;
import resources.AppConsts;

@WebServlet( "/CadastroVeiculoServlet" )
public class CadastroVeiculoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastroVeiculoServlet() {
		super();

	}

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String validarMotorista = request.getParameter( "motoristaIndex" );
		String validarVeiculo = request.getParameter( "veiculoIndex" );

		Veiculo veiculo = DaoFactory.getDaoFactory().getVeiculoDao().getVeiculoList().get( Integer.parseInt( validarVeiculo ) );
		if ( validarMotorista.equals( "desalocar" ) ) {
			veiculo.getMotorista().setDisponivel( true );
			veiculo.setMotorista( null );
		} else {
			Motorista motorista = DaoFactory.getDaoFactory().getMotoristaDao().getMotoristaList().get( Integer.parseInt( validarMotorista ) );
			veiculo.setMotorista( motorista );
			motorista.setDisponivel( false );
		}

		response.sendRedirect( AppConsts.CAMINHO + "/home.jsp" );
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String marca = request.getParameter( "marca" );
		String ano = request.getParameter( "ano" );
		String placa = request.getParameter( "placa" );
		String validarMotorista = request.getParameter( "motorista" );
		int modeloIndex = Integer.parseInt( request.getParameter( "modelo" ) );
		Modelo modelo = DaoFactory.getDaoFactory().getModeloDao().getModeloList().get( modeloIndex );
		MotoristaDao motoristaDao = DaoFactory.getDaoFactory().getMotoristaDao();

		if ( validarMotorista.equals( "N" ) ) {
			Veiculo veiculo = new Veiculo( marca, modelo, ano, placa );
			DaoFactory.getDaoFactory().getVeiculoDao().adicionarVeiculo( veiculo );
			response.sendRedirect( AppConsts.CAMINHO + "/home.jsp" );
		} else {
			int motoristaIndex = Integer.parseInt( validarMotorista );
			Motorista motorista = DaoFactory.getDaoFactory().getMotoristaDao().getMotoristaList().get( motoristaIndex );
			String tipoCNH = String.valueOf( motorista.getTipoCNH() );
			if ( tipoCNH.equals( "B" ) && modeloIndex == 2 && motorista.isDisponivel() ) {
				Veiculo veiculo = new Veiculo( marca, modelo, ano, placa );
				veiculo.setMotorista( motorista );
				motoristaDao.setDisponivel( motorista.getId(), false );
				DaoFactory.getDaoFactory().getVeiculoDao().adicionarVeiculo( veiculo );
				response.sendRedirect( AppConsts.CAMINHO + "/home.jsp" );

			} else if ( tipoCNH.equals( "C" ) && motorista.isDisponivel() ) {
				Veiculo veiculo = new Veiculo( marca, modelo, ano, placa );
				veiculo.setMotorista( motorista );
				motoristaDao.setDisponivel( motorista.getId(), false );
				DaoFactory.getDaoFactory().getVeiculoDao().adicionarVeiculo( veiculo );
				response.sendRedirect( AppConsts.CAMINHO + "/home.jsp" );
			} else {
				response.sendRedirect( AppConsts.CAMINHO + "/ui.cadastro/falhaCadastroVeiculo.jsp" );
			}
		}

	}

}

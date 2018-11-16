package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resources.AppConsts;
import resources.GerenciadorData;

/**
 * Servlet implementation class BuscaRoteiroServlet
 */
@WebServlet( "/BuscaRoteiroServlet" )
public class BuscaRoteiroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscaRoteiroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String dataString = request.getParameter( "data" );

		if ( null == dataString || dataString.isEmpty() ) {
			dataString = GerenciadorData.getInstance().dataAtual();
		}
		response.sendRedirect( AppConsts.CAMINHO + "/roteiro/listarRoteiros.jsp?data=" + dataString );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.doGet( request, response );
	}

}

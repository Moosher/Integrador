package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Objeto;
import model.dao.DaoFactory;
import model.dao.ObjetoDao;
import resources.AppConsts;

@WebServlet( "/CadastroObjetoServlet" )
public class CadastroObjetoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CadastroObjetoServlet() {
	super();
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	String nomeRemetente = request.getParameter( "nomeRemetente" );
	String enderecoRemetente = request.getParameter( "enderecoRemetente" );
	String nomeDestinatario = request.getParameter( "nomeDestinatario" );
	String enderecoDestinatario = request.getParameter( "enderecoDestinatario" );
	double peso = Double.parseDouble( request.getParameter( "peso" ) );
	String codLocalizador = request.getParameter( "cod" );
	Date dataDeposito = new Date();

	try {
	    ObjetoDao objetoDao = DaoFactory.getDaoFactory().getObjetoDao();
	    if ( objetoDao.verificaCodigo( codLocalizador ) ) {
		Objeto objeto = new Objeto( codLocalizador, nomeRemetente, enderecoRemetente, nomeDestinatario, enderecoDestinatario, dataDeposito, peso );
		objetoDao.adicionarObjeto( objeto );

		response.sendRedirect( AppConsts.CAMINHO + "/ui.cadastro/reciboObjeto.jsp?id=" + objeto.getCodigoLocalizador() + "&nomeR=" + nomeRemetente + "&enderecoR=" + enderecoRemetente + "&nomeD="
			+ nomeDestinatario + "&enderecoD=" + enderecoDestinatario + "&dataDeposito=" + dataDeposito + "&peso=" + peso );

	    } else {
		response.sendRedirect( AppConsts.CAMINHO + "/ui.cadastro/falhaCadastroObjeto.jsp" );
	    }

	} catch ( NullPointerException nullPointerException ) {
	    response.sendRedirect( AppConsts.CAMINHO + "/ui.cadastro/falhaCadastroObjeto.jsp" );

	}

    }

}

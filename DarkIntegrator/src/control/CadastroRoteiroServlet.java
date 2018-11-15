package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoFactory;
import model.dao.RoteiroDao;
import resources.AppConsts;

@WebServlet("/CadastroRoteiroServlet")
public class CadastroRoteiroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CadastroRoteiroServlet() {
	super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RoteiroDao roteiro = DaoFactory.getDaoFactory().getRoteiroDao();
	Date data = new Date();
	roteiro.gerarRoteiros(data);

	response.sendRedirect(AppConsts.CAMINHO + "/home.jsp");
    }

}

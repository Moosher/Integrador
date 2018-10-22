package control;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoFactory;
import model.dao.RoteiroDao;
import resources.AppConsts;
import resources.GerenciadorData;

@WebServlet("/CadastroRoteiroServlet")
public class CadastroRoteiroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastroRoteiroServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RoteiroDao roteiro = DaoFactory.getDaoFactory().getRoteiroDao();
			Date data = GerenciadorData.getInstance().dateAtual();
			roteiro.gerarRoteiros(data);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.sendRedirect(AppConsts.CAMINHO + "/home.jsp");
	}

}

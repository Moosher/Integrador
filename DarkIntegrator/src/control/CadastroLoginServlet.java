package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoFactory;
import model.dao.arquivo.FileControl;
import resources.AppConsts;

@WebServlet("/CadastroLoginServlet")
public class CadastroLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastroLoginServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("nome");
		String senha = request.getParameter("senha");

		if (request.getParameter("checkbanco") == null) {
			AppConsts.BANCO = false;
			FileControl.getInstance();
		} else {
			AppConsts.BANCO = true;

		}
		System.out.println(AppConsts.BANCO);
		DaoFactory.getDaoFactory().getUsuarioDao().adicionarUsuario(login, senha);

		response.sendRedirect(AppConsts.CAMINHO + "/welcome.jsp?nome=" + login + "&senha=" + senha);

	}

}

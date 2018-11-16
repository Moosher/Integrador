package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import resources.AppConsts;

/**
 * Servlet implementation class receiveServlet
 */
@WebServlet("/ReceiveServlet")
public class ReceiveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveServlet() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (request.getParameter("checkbanco") == null) {
	    AppConsts.BANCO = false;
	} else {
	    AppConsts.BANCO = true;
	}

	String loginControl = request.getParameter("login");
	String senhaControl = request.getParameter("senha");
	UsuarioDao vl = DaoFactory.getDaoFactory().getUsuarioDao();
	boolean loginResponse = vl.validacao(loginControl, senhaControl);


	if (loginResponse == true) {
	    HttpSession session = request.getSession();
	    session.setAttribute("usuario", loginControl);
	    response.sendRedirect(AppConsts.CAMINHO + "/home.jsp");

	} else {
	    response.sendRedirect(AppConsts.CAMINHO + "/loginFalha.jsp");
	}

    }

}

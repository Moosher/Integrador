package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Objeto;
import model.Objeto.Status;
import model.dao.DaoFactory;
import model.dao.RoteiroDao;
import resources.AppConsts;

/**
 * Servlet implementation class RetornoRoteiroServlet
 */
@WebServlet("/RetornoRoteiroServlet")
public class RetornoRoteiroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetornoRoteiroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] entrega = new String[10];
		String roteiroId = request.getParameter("roteiroId");
		RoteiroDao roteiros = DaoFactory.getDaoFactory().getRoteiroDao();
		entrega[0] = request.getParameter("entrega0") == null ? "" : request.getParameter("entrega0");
		entrega[1] = request.getParameter("entrega1") == null ? "" : request.getParameter("entrega1");
		entrega[2] = request.getParameter("entrega2") == null ? "" : request.getParameter("entrega2");
		entrega[3] = request.getParameter("entrega3") == null ? "" : request.getParameter("entrega3");
		entrega[4] = request.getParameter("entrega4") == null ? "" : request.getParameter("entrega4");
		entrega[5] = request.getParameter("entrega5") == null ? "" : request.getParameter("entrega5");
		entrega[6] = request.getParameter("entrega6") == null ? "" : request.getParameter("entrega6");
		entrega[7] = request.getParameter("entrega7") == null ? "" : request.getParameter("entrega7");
		entrega[8] = request.getParameter("entrega8") == null ? "" : request.getParameter("entrega8");
		entrega[9] = request.getParameter("entrega9") == null ? "" : request.getParameter("entrega9");
		int i = 0;
		for (Objeto objeto : roteiros.getObjetoRoteiroList(roteiroId)) {
			if (entrega[i].equals("S")) {
				DaoFactory.getDaoFactory().getObjetoDao().setStatus(objeto.getId(), Status.ENTREGUE);
			} else {
				DaoFactory.getDaoFactory().getObjetoDao().setStatus(objeto.getId(), Status.PENDENTE);

			}
		}
		response.sendRedirect(AppConsts.CAMINHO + "/home.jsp");
	}
}

package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Compte;
import service.CompteService;

/**
 * Servlet implementation class ServletLireCompte
 */
@WebServlet("/ServletLireCompte")
public class ServletLireCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLireCompte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * cette methode recupere l'idClient entre par le biais du formulaire present sur la page jsp
	 * elle fait appel a la methode lireInfoCompteByID() de la classe CompteService qui retourne une liste de compte en fonction de l'id du client
	 * puis  redirige l'utilisateur vers une page jsp sur laquelle la liste de compte du client sera visible
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteService cs = new CompteService();
		List<Compte> comptes;
		
		String idClient = request.getParameter("idClient");
		if (idClient!=null) {
		int idClient1 = Integer.parseInt(idClient);
		
		comptes = cs.lireInfoCompteByID(idClient1);
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("InfoCompte", comptes);

		request.setAttribute("idClient", idClient);
		request.setAttribute("InfoCompte", comptes);
		
		this.getServletContext().getRequestDispatcher("/listeCompte.jsp").forward(request, response);
		}
	}

}

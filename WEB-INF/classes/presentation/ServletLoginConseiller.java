package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ConseillerService;

/**
 * Servlet implementation class ServletLoginConseiller
 */
@WebServlet("/ServletLoginConseiller")
public class ServletLoginConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoginConseiller() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}
	
	
	/**
	 * methode qui traite les informations recuperees par le biais du formulaire present sur la page jsp authentificationConseiller
	 * elle fait appel a la methode login() de la classe ConseillerService qui retourne un boolean
	 * et, selon que le retour soit true ou false elle permet de rediriger l'utilisateur vers une page jsp par le biais
	 * du request dispatcher
	 * elle met egalement le login du conseiller en session
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ConseillerService cs = new ConseillerService();
		RequestDispatcher dispatcher;
		boolean resLogin = cs.login(request);
		
		String erreur = "Problème lors de la connexion, le login ou le mot de passe est incorrect. Veuillez-réessayer :";
		String login = request.getParameter("login");
		HttpSession maSession = request.getSession();
		maSession.setAttribute("erreur", erreur);
		maSession.setAttribute("login", login);
		
		if (resLogin) {
		
			dispatcher = request.getRequestDispatcher("obtenirClient.jsp");		
			dispatcher.forward(request,response);
			
		} else {
			
			dispatcher = request.getRequestDispatcher("erreurLogin2.jsp");
			dispatcher.forward(request, response);
		}
	
		
		
	}

}

package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CompteService;

/**
 * Servlet implementation class ServletVirement
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVirement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}
	
	
	/**
	 * cette methode recupere les informations entrees dans le formulaire de la page jsp
	 * elle les met en session 
	 * puis elle fait appel a la methode virement() de la classe CompteService qui retourne un boolean
	 * en fonction du retour recupere elle dirige l'utilisateur vers une nouvelle page jsp par le biais du request dispatcher
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String montant = request.getParameter("montant");
        String numCompteDebite = request.getParameter("numCompteDebite");
        String numCompteCredite = request.getParameter("numCompteCredite");
                
        String erreur2 = "Le montant indiqué est trop élevé ou le compte débité et le compte crédité sont identiques";
        HttpSession maSession = request.getSession();
        maSession.setAttribute("montant", montant);
        maSession.setAttribute("numCompteDebite", numCompteDebite);
        maSession.setAttribute("numCompteCredite", numCompteCredite);
        maSession.setAttribute("erreur2", erreur2);
        
        RequestDispatcher dispatcher;
        
        CompteService cs = new CompteService();
        boolean virement = cs.virement(request);
        
        if (virement){
            dispatcher = request.getRequestDispatcher("resultatVirement.jsp");
            dispatcher.forward(request,response);
        }else {
        	dispatcher = request.getRequestDispatcher("erreurVirement.jsp");
			dispatcher.forward(request, response);
        }
	}

}

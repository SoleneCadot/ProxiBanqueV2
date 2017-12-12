package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ClientService;

/**
 * Servlet implementation class ServletModifierClient
 */
@WebServlet("/ServletModifierClient")
public class ServletModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ServletModifierClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * methode qui recupere les modification apportees par le conseiller sur son client
	 * elle fait appel aux différentes methodes modifier ainsi qu'a la methode lireClientModifier() de la classe ClientService 
	 * pour renvoyer l'utilisateur vers une page jsp sur laquelle le client avec ses nouvelles informations affichees
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientService clientmodif = new ClientService();
		
		 /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
		
		String idClient = request.getParameter("idclient");//récupération via la session
		int idclient1 = Integer.parseInt(idClient);
		
		String nomClient = request.getParameter("nom");
		String prenomClient = request.getParameter("prenom");
		String adresseClient = request.getParameter("adresse");
		String mailClient = request.getParameter("mail");
		
		Client client1 = new Client();
		clientmodif.modifierClientNom(idclient1, nomClient);
		clientmodif.modifierClientPrenom(idclient1,prenomClient);
		clientmodif.modifierClientAdresse(idclient1,adresseClient);
		clientmodif.modifierClientMail(idclient1,mailClient);
		
		client1 = clientmodif.lireClientMdofifier(idclient1);

		request.setAttribute("ClientModifier", client1);
		
		
		this.getServletContext().getRequestDispatcher("/lireClientModifier.jsp").forward(request, response);	
	}

}

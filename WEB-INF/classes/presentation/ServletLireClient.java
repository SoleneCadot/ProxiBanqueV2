package presentation;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import service.ClientService;

/**
 * Servlet implemente la classe ServletLireClient
 */
@WebServlet("/ServletLireClient")
public class ServletLireClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLireClient() {
        super();

    }

	/**
	 * elle fait appel a la methode selectAll() de la classe ClientService qui retourne une liste de client
	 * puis met la liste de client en session pour rediriger l'utilisateur vers une page jsp sur laquelle la liste de client sera visible
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ClientService cs = new ClientService();
		List<Client> clients = cs.selectAll(request);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("listeClient", clients);
		
		this.getServletContext().getRequestDispatcher("/listeClient.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

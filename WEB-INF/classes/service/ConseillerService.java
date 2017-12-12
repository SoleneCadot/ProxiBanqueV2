package service;

import javax.servlet.http.HttpServletRequest;

import dao.DAOConseiller;

public class ConseillerService {
	
	/**
	 * cette methode recupere les parametres login et password entres dans le formulaire de la page jsp 
	 * elle fait appel a la methode login() de la classe DAOConseiller avec pour parametre le login et mot de passe recuperes
	 * elle recupere de cette maniere un boolean qu'elle retourne
	 * @param request
	 * @return boolean
	 */
	public boolean login(HttpServletRequest request) {
		
		DAOConseiller dc = new DAOConseiller();
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("password");
		
		boolean resLogin = dc.login(login, pwd);
		
		return resLogin;		
		
	}

}

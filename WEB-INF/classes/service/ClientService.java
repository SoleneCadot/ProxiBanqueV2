package service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOClient;
import metier.Client;

/**
 * classe contenant des methodes qui font appels aux methodes contenues dans la classe DAOClient
 *
 */
public class ClientService {
	
	/**
	 * cette methode récupère le login du conseiller mis en session par la servlet ServletLoginConseiller
	 * puis fait appel a methode selectAll() contenue dans la couche DAOClient avec en parametre le login recupere
	 * selectAll retourne la liste de client du conseiller identifier qui va etre egalement le retour de cette methode
	 * 
	 * @param request
	 * @return List<Client>
	 */
	public List<Client> selectAll(HttpServletRequest request) {
			 
		HttpSession maSession = request.getSession();
		String log = (String) maSession.getAttribute("login");
		DAOClient daoClient = new DAOClient();
		List<Client> clients = daoClient.selectAll(log);
			
		return clients;
	}
	
	
	/**
	 * methode faisant appel a la methode modifiNomClient() de la classe DAOClient
	 * s'effectue uniquement si l'utilisateur a rempli le champ 'nom' du formulaire present sur la page jsp
	 * @param idClient
	 * @param nomClient
	 */
	public void modifierClientNom(int idClient, String nomClient) {
		 
		 DAOClient daoClient = new DAOClient ();
		 	if (nomClient != "") {
		 		daoClient.modifiNomClient(idClient, nomClient);
		 	}else {
		 	}
	}
	
	
	
	/**
	 *  methode faisant appel a la methode modifiPrenomClient() de la classe DAOClient
	 * s'effectue uniquement si l'utilisateur a rempli le champ 'prenom' du formulaire present sur la page jsp
	 * @param idClient
	 * @param prenomClient
	 */
	public void modifierClientPrenom(int idClient, String prenomClient) {
		 
		 DAOClient daoClient = new DAOClient ();
		 	if (prenomClient != ""){
		 		daoClient.modifiPrenomClient(idClient, prenomClient);
		 	}else {
		 	}
	}
	
	
	/**
	 *  methode faisant appel a la methode modifiAdresseClient() de la classe DAOClient
	 * s'effectue uniquement si l'utilisateur a rempli le champ 'adresse' du formulaire present sur la page jsp
	 * @param idClient
	 * @param adresseClient
	 */
	public void modifierClientAdresse(int idClient, String adresseClient) {

		DAOClient daoClient = new DAOClient ();
			if (adresseClient != ""){
				daoClient.modifiAdresseClient(idClient, adresseClient);
			}else {
			}
	}
	
	
	/**
	 *  methode faisant appel a la methode modifierClientMail() de la classe DAOClient
	 * s'effectue uniquement si l'utilisateur a rempli le champ 'email' du formulaire present sur la page jsp
	 * @param idClient
	 * @param mailClient
	 */
	public void modifierClientMail(int idClient, String mailClient) {

		DAOClient daoClient = new DAOClient ();
			if (mailClient != ""){
				daoClient.modifiMailClient(idClient, mailClient);
			}else {
			}
	}

	
	/**
	 * methode faisant appel a la methode selectClientByIdClient() de la classe DAOClient
	 * elle recupere les informations d'un client par le biais de son id et le retourne
	 * @param idClient
	 * @return Client
	 */
	public Client lireClientMdofifier(int idClient) {
		DAOClient daoClient = new DAOClient ();
		Client client1 = new Client();
		client1 = daoClient.selectClientByIdClient(idClient);
		return client1;
	}
	
}



package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.DAOCompte;
import metier.Compte;

public class CompteService {
	
	/**
	 * Cette methode fait appel a la methode selectAllCompteByIdClient() de la classe DAOCompte
	 * qui va lui retourner la liste de compte du client correspondant a l'idclient
	 * qu'elle va elle-meme retourner
	 * 
	 * @param idClient
	 * @return List<Compte>
	 */
	public List<Compte> lireInfoCompteByID(int idClient) {
		
		DAOCompte dc = new DAOCompte();
		List<Compte> comptes = dc.selectAllCompteByIdClient(idClient);
		
		return comptes;
	}

	
	/**
	 * methode recuperant les parametres entres dans le formulaire de la page jsp
	 * elle fait appel a la methode recupSoldeCompteDebite() et recupSoldeCompteCredite()
	 * pour obtnir les soldes des comptes par le biais de leur numero de compte
	 * a condition que le montant soit inferieur au compte debite et que les deux comptes entres soient differents la methode fait alors appel
	 * a la methode updateSoldeVirement() de la classe DAOCompte dans ce cas elle va retourner un true
	 * sinon elle retournera un false
	 * 
	 * @param request
	 * @return boolean
	 */
	public boolean virement(HttpServletRequest request){
		
		boolean vir = false;
		
        String montant = request.getParameter("montant");
        String numCompteDebite = request.getParameter("numCompteDebite");
        String numCompteCredite = request.getParameter("numCompteCredite");
        
        double montantV = Double.parseDouble(montant);
        int numCompteDeb = Integer.parseInt(numCompteDebite);
        int numCompteCred = Integer.parseInt(numCompteCredite);
        
        DAOCompte dc = new DAOCompte();
        double solde1 = dc.recupSoldeCompteDebite(numCompteDeb);
        double solde2 = dc.recupSoldeCompteCredite(numCompteCred);
        
        if (numCompteDeb != numCompteCred && montantV < solde1) {
            dc.updateSoldeVirement(numCompteDeb, numCompteCred, montantV, solde1, solde2);
            vir = true;
            return vir;
        }
		return vir;
    }
}

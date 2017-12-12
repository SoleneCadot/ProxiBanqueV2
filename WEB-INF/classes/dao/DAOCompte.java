package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Compte;

/**
 * classe contenant les methodes qui permettent de recuperer et de modifier les informations
 * des comptes presentes en base de donnees
 */
public class DAOCompte {
	
	/**
	 * cette methode permet de recuperer la liste de compte d'un client 
	 * a partir de l'id du client
	 * @param idClient
	 * @return list<Compte>
	 */
	public List<Compte> selectAllCompteByIdClient(int idClient){
		
        List<Compte> comptes = new ArrayList<Compte>();
        
		try {
			AccesBDD bdd = new AccesBDD();
            Connection cnx = bdd.seConnecter();
            
            Statement stmt = cnx.createStatement();
            String s ="select * from compte where idclient = '"+idClient+"'";
            
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()){
                int n = rs.getInt("numerocompte");
                String t = rs.getString("type");
                double so = rs.getDouble("solde");
                String d = rs.getString("dateouverture");
                Compte compte = new Compte(n, t, so, d);
                comptes.add(compte);
            }
            
            bdd.seDeconnecter(cnx);
            
        } catch (SQLException e) {
			System.out.println("erreur base de donnée");
			e.printStackTrace();
        }
		
		return comptes;
	}
	
	
	
	
	 //on récupère le solde du compte a debiter
    /**
     * methode permettant de recuperer les informations relatives au solde d'un compte a debiter
     * dans le cadre d'un virement
     * @param numCompteDebite
     * @return double
     */
    public double recupSoldeCompteDebite(int numCompteDebite) {
        
        String s = "select solde from compte where numeroCompte = '" + numCompteDebite + "'";
        double solde1 = 0;
        try {
        	AccesBDD bdd = new AccesBDD();
        	Connection cnx = bdd.seConnecter();
        
        	Statement st = cnx.createStatement();
        
        	ResultSet rs = st.executeQuery(s);
        	while (rs.next()) {
        		solde1 = rs.getDouble("solde");
        	}
        	
        	bdd.seDeconnecter(cnx);
        
        } catch (SQLException e) {
			System.out.println("erreur base de donnée solde1");
			e.printStackTrace();
        }
        
        return solde1;
    }    

    
    //on recupere le solde du compte a crediter
    /**
     * methode permettant de recuperer les informations relatives au solde d'un compte a crediter
     * dans le cadre d'un virement
     * @param numCompteCredite
     * @return
     */
    public double recupSoldeCompteCredite(int numCompteCredite) {
        
        String s = "select solde from compte where numeroCompte = '" + numCompteCredite + "'";
        double solde2 = 0;
        try {
        	AccesBDD bdd = new AccesBDD();
        	Connection cnx = bdd.seConnecter();
        
        	Statement st = cnx.createStatement();
        
        	ResultSet rs = st.executeQuery(s);
        	while (rs.next()) {
        		solde2 = rs.getDouble("solde");
        	}
        	
        	bdd.seDeconnecter(cnx);
        
        } catch (SQLException e) {
			System.out.println("erreur base de donnée solde2");
			e.printStackTrace();
        }
        
        return solde2;
    }    
    
    
    //on update les deux soldes
    /**
     * methode mettant a jour le solde du compte debite et du compte credite dans le cadre d'un virement
     * 
     * @param numCompteDebite
     * @param numCompteCredite
     * @param montant
     * @param solde1
     * @param solde2
     */
    public void updateSoldeVirement (int numCompteDebite, int numCompteCredite, double montant, double solde1, double solde2){
    	double nouveauSolde1 = (solde1 - montant);
    	double nouveauSolde2 = (solde2 + montant);
    	
        String s = "update compte set solde = " + nouveauSolde1 + " where numeroCompte = "+ numCompteDebite ;
        String s2 = "update compte set solde = " + nouveauSolde2 + " where numeroCompte = "+ numCompteCredite ;
        try {
        	AccesBDD bdd = new AccesBDD();
        	Connection cnx = bdd.seConnecter();
        
        	Statement st = cnx.createStatement();
        	st.execute(s);
        	st.execute(s2);
        	
        	bdd.seDeconnecter(cnx);
        	
        } catch (SQLException e) {
			System.out.println("erreur base de donnée update solde");
			e.printStackTrace();
        }
        
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Client;



/**
 * cette classe contient les methodes relatives a la recuperation et a la mise a jour 
 * des donnees client en base de donnees
 *
 */
public class DAOClient {
	
	/**
	 * Cette methode permet de recuperer toutes les informations relatives a tous les clients
	 * d'un conseiller presentes en base de donnees a partir du login du conseiller 
	 * present en base de donnees
	 * @param login
	 */
	public List<Client> selectAll(String login){
		
        List<Client> clients = new ArrayList<Client>();
        
        try {
			AccesBDD bdd = new AccesBDD();
            Connection cnx = bdd.seConnecter();
            
            Statement stmt = cnx.createStatement();
            String s ="select * from Client where login ='" + login + "'";
            ResultSet rs = stmt.executeQuery(s);
            
            while (rs.next()){
                int i = rs.getInt("idclient");
                String n = rs.getString("nomClient");
                String p = rs.getString("prenomClient");
                String a = rs.getString("adresse");
                String e = rs.getString("email");
                Client client = new Client(i, n, p, a, e);
                clients.add(client);
            }
            
            bdd.seDeconnecter(cnx);
            
        } catch (SQLException e) {
			System.out.println("erreur base de donnée selection liste client");
			e.printStackTrace();
			
		}
		return clients;
    }
	
	
	
	/**
	 * cette methode permet de modifier le nom d'un client en base de donnees à partir de son id
	 * @param idclient
	 * @param nom
	 */
	public void modifiNomClient(int idclient, String nom){
		try {
			AccesBDD bdd = new AccesBDD();
            Connection cnx= bdd.seConnecter();
            
            String s ="update client" + " set nomclient = ? where IDCLIENT = ?";
            PreparedStatement pstmt;
            
            pstmt=cnx.prepareStatement(s);    
            pstmt.setString(1,nom);
            pstmt.setInt(2,idclient);
            pstmt.executeUpdate();
           
            bdd.seDeconnecter(cnx);
            
        } catch (SQLException e) {
        	System.out.println("erreur base de donnée modification nom client");
			e.printStackTrace();
        }
   
    }

	

	/**
	 * cette methode permet de modifier le prenom d'un client en base de donnees à partir de son id
	 * @param idclient
	 * @param prenom
	 */
	public void modifiPrenomClient(int idclient, String prenom){
			try {
				AccesBDD bdd = new AccesBDD();
	            Connection cnx= bdd.seConnecter();
	            
	            String s ="update client" + " set prenomclient = ? where IDCLIENT = ?";
	            PreparedStatement pstmt;
	            
	            pstmt=cnx.prepareStatement(s);    
	            pstmt.setString(1,prenom);
	            pstmt.setInt(2,idclient);
	            pstmt.executeUpdate();
	           
	            bdd.seDeconnecter(cnx);
	            
	        } catch (SQLException e) {
	        	System.out.println("erreur base de donnée modification prenom client");
				e.printStackTrace();
	        }
	}
	
	

	/**
	 * cette methode permet de modifier l'adresse d'un client en base de donnees à partir de son id
	 * @param idclient
	 * @param adresse
	 */
	public void modifiAdresseClient(int idclient, String adresse){
		try {
			AccesBDD bdd = new AccesBDD();
            Connection cnx= bdd.seConnecter();
            
	        String s ="update client" + " set adresse = ? where IDCLIENT = ?";
	        PreparedStatement pstmt;
	            
	        pstmt=cnx.prepareStatement(s);    
	        pstmt.setString(1,adresse);
	        pstmt.setInt(2,idclient);
	        pstmt.executeUpdate();
	            
	        bdd.seDeconnecter(cnx);
	        
		} catch (SQLException e) {
			System.out.println("erreur base de donnée modification adresse client");
			e.printStackTrace();
	    }
	    
	}

	
	
	/**
	 * cette methode permet de modifier l'email d'un client en base de donnees à partir de son id
	 * @param idclient
	 * @param mail
	 */
	public void modifiMailClient(int idclient, String mail){
		try {
			AccesBDD bdd = new AccesBDD();
	        Connection cnx= bdd.seConnecter();
	            
	        String s ="update client" + " set email = ? where IDCLIENT = ?";
	        PreparedStatement pstmt;
	            
	        pstmt=cnx.prepareStatement(s);    
	        pstmt.setString(1,mail);
	        pstmt.setInt(2,idclient);
	        pstmt.executeUpdate();
	            
	        bdd.seDeconnecter(cnx);
	            
	    } catch (SQLException e) {
	    	System.out.println("erreur base de donnée modification email client");
			e.printStackTrace();
	    }	    
    }
		
	
	
	/**
	 * cette methode permet de recuperer les informations presentes en base de donnees d'un client 
	 * a partir de son id
	 * @param idClient
	 * @return client
	 */
	public Client selectClientByIdClient(int idClient){
	        
		Client client1=new Client();
	        
	    try {
	        AccesBDD bdd = new AccesBDD();
	        Connection cnx= bdd.seConnecter();
	            
	        Statement stmt = cnx.createStatement();
	        String s ="select * from client where idclient = '"+idClient+"'";
	        ResultSet rs = stmt.executeQuery(s);
	        
	        while (rs.next()){
	        	int i = rs.getInt("idClient");
	            String n = rs.getString("nomclient");
	    	    String p = rs.getString("prenomclient");
	    	    String a = rs.getString("adresse");
	    	    String e = rs.getString("email");
	    	        
	    	    client1.setIdClient(i);
	    	    client1.setNom(n);
	    	    client1.setPrenom(p);
	    	    client1.setAdresse(a);
	    	    client1.setEmail(e);
	    	        
	            }
	            
	        bdd.seDeconnecter(cnx);
	            
	    } catch (SQLException e) {
	    		System.out.println("erreur base de donnée recuperation info client");
				e.printStackTrace();
	    }
	    return client1;
	    
	}
}



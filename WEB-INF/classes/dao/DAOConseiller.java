package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * classe contenant la methode verifiant le login et le mot de passe d'un conseiller
 * @author adminl
 *
 */
public class DAOConseiller {
	
	/**
	 * methode comparant le login et le mot de passe entrer par un conseiller avec ceux presents en base de donnees
	 * @param login
	 * @param pwd
	 * @return boolean
	 */
	public boolean login(String login, String pwd){
		
		AccesBDD bdd = new AccesBDD();
		boolean resLogin = false;
		
		try {
			
			String s = "select * from Conseiller where login = '" + login + "' and password ='" + pwd + "'";
			System.out.println(s);
			
			Connection cnx = bdd.seConnecter();
			
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(s);
			resLogin = rs.next();
			bdd.seDeconnecter(cnx);
			
			return resLogin;
			
		} catch (SQLException e) {
			System.out.println("erreur base de donnée");
			e.printStackTrace();
			
		}
		return resLogin;
	}

}

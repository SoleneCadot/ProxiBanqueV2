package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe contient les methodes seConnecter et seDeconnecter qui permettent de se connecter et de se deconnecter 
 * a la base de donnees
 */
public class AccesBDD {
	
	private static final String pilote = "oracle.jdbc.OracleDriver";
    
    
    /**
     * Cette methode permet de se connecter a la base de donnees
     * @return connexion
     */
    public Connection seConnecter() {
        Connection cnx = null;
        try {
            Class.forName(pilote);
            cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "solene", "solene");   
       
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connexion à la base impossible");
          }
        
        return cnx;
    }
    

    /**
     * Cette méthode permet de se deconnecter a la base de donnees
     * @param connexion
     */
    public void seDeconnecter(Connection cnx) {
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("deconnexion impossible");
        }
    }

}

/*
 *  
 */
package metier;

/**
 * Cette classe possede les attributs communs aux conseillers et aux clients
 * ainsi que les getters, setters et le constructeur qui s'y rapportent.
 * 
 */
public class Personne {
    
    //Attributs
    private String nom;
    private String prenom;
    
    //getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    //setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    //constructeur
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

	public Personne() {
		super();
	}
    
    
}

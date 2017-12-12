/*
 */
package metier;

import java.util.List;

/**
 * Cette classe herite de la classe Personne.
 * Elle contient les attributs d'un client ainsi que les getters,
 * setters et le constructeur qui s'y rapportent.
 */
public class Client extends Personne {
    
	private int idClient;
    private String adresse;
    private String email;
    private Conseiller conseiller;
    private List<Compte> comptes;
    
    
    //getters
    public int getIdClient() {
		return idClient;
	}

    public String getAdresse() {
        return adresse;
    }

	public String getEmail() {
        return email;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public List<Compte> getComptes() {
        return comptes;
    }
    
    
    
    
    //setters
    public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    
    
    
    
    //constructeur
    public Client(String adresse, String email, Conseiller conseiller, List<Compte> comptes, String nom, String prenom) {
        super(nom, prenom);
        this.adresse = adresse;
        this.email = email;
        this.conseiller = conseiller;
        this.comptes = comptes;
    }

	public Client(int idClient, String nom, String prenom, String adresse, String email) {
		super(nom, prenom);
		this.idClient = idClient;
		this.adresse = adresse;
		this.email = email;
	}

	public Client() {
	}

	//toString
    @Override
    public String toString() {
        return "Client n°" + getIdClient() + getNom() + getPrenom() + getAdresse() + getEmail();
    }
    
    
}

/*
 */
package metier;

/**
 * Cette classe contient les attributs des comptes, ainsi que les getters,
 * les setters et le constructeur qui s'y rapportent.
 * 
 */
public class Compte {
    
    //attributs
    private int numeroCompte;
    private String type;
    private double solde;
    private String dateOuverture;
    private Client client;
    
    
    //getters
    public int getNumeroCompte() {
        return numeroCompte;
    }    

    public String getType() {
		return type;
	}

	public double getSolde() {
        return solde;
    }

    public String getDateOuverture() {
        return dateOuverture;
    }

    public Client getClient() {
        return client;
    }
    
    
    //setters
    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    public void setType(String type) {
		this.type = type;
	}

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    //constructeur
    public Compte(int numeroCompte, String type, double solde, String dateOuverture) {
        this.numeroCompte = numeroCompte;
        this.type = type;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Compte{" + "numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", client=" + client + '}';
    }
    
    
}

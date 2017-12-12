/*
 */
package metier;

import java.util.List;

/**
 * Cette classe herite de la classe personne.
 * Elle contient les attributs d'un conseiller ainsi que les getters,
 * setters et le constructeur qui s'y rapportent.
 */
public class Conseiller extends Personne {
    
    //Attributs
	private int idConseiller;
    private String login;
    private String password;
    private List<Client> clients;
    
    
    //getters
    public int getIdConseiller() {
		return idConseiller;
	}
    
    public String getLogin() {
        return login;
    }

	public String getPassword() {
        return password;
    }

    public List<Client> getClients() {
        return clients;
    }
    
    
    
    //setters
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

    
    
    //constructeur
    
    public Conseiller(String login, String password, String nom, String prenom, List<Client> clients) {
        super(nom, prenom);
        this.login = login;
        this.password = password;
        this.clients = clients;
    }

    public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

    
	//toString
    @Override
    public String toString() {
        return "Conseiller{" + "login=" + login + ", password=" + password + ", clients=" + clients + '}';
    }
    
    
    
    
    
    
}

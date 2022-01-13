package magazin;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Biblioteca {
	
	@Id
	private int idBiblioteca;
	
	@OneToOne(mappedBy = "biblioteca")
    private Client client;
    
    @OneToMany(mappedBy = "biblioteca")
	private LinkedList<Produse> continut = new LinkedList<Produse>();

    public Biblioteca(int idBiblioteca, Client client, LinkedList<Produse> continut) {
        this.idBiblioteca = idBiblioteca;
        this.client = client;
        this.continut = continut;
    }
    
    public Biblioteca() {
    	
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LinkedList<Produse> getContinut() {
        return continut;
    }

    public void setContinut(LinkedList<Produse> continut) {
        this.continut = continut;
    }

	@Override
	public String toString() {
		return "Biblioteca [idBiblioteca=" + idBiblioteca + ", client=" + client + ", continut=" + continut + "]";
	}
    
    
}

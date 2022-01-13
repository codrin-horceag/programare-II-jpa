package magazin;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	private String numeClient;
    private int idClient;
    private String adresa;    
    private Biblioteca biblioteca;

    public Client(String numeClient, int idClient, String adresa) {
        this.numeClient = numeClient;
        this.idClient = idClient;
        this.adresa = adresa;
    }
    
    public Client() {
    	
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

	@Override
	public String toString() {
		return "Client [numeClient=" + numeClient + ", idClient=" + idClient + ", adresa=" + adresa + ", biblioteca="
				+ biblioteca + "]";
	}
    
}

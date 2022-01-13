package formulare;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import magazin.Client;

@ManagedBean @SessionScoped
public class FormularClienti {
//declarare
	private List<Client> clienti = new ArrayList<Client>();
	private Client client;
	
	public List<Client> getClienti() {
		return clienti;		
	}
	
	public void setClienti(List<Client> clienti) {
		this.clienti = clienti;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Integer getIdClient(){	
		return this.client.getIdClient();
	}
	
	public void setIdClient(Integer id) {
		Integer index = this.clienti.indexOf(new Client(null, id, null));
		this.client = this.clienti.get(index);
	}

	
//initializare formular
	
	private EntityManager em;
	
	public FormularClienti() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProiectJPA");
		em = emf.createEntityManager();
		init();
	}

private void init() {
		this.clienti = em.createQuery("SELECT c FROM Client c ORDER BY c.idClient", Client.class).getResultList();
		
		if(!clienti.isEmpty()) {
			this.setClient(clienti.get(0));
		}
		
	}

//navigare

		public void previousClient(ActionEvent evt) {
			System.out.println("<<<---- Client Anterior");
			
			Integer index = this.getIdClient();
			System.out.println(index);
			if(index > 0)
				this.client = this.clienti.get(index - 1);
		}
		public void nextClient(ActionEvent evt) {
			System.out.println("---->>> Client Urmator");
			System.out.println(this.client);
			System.out.println(this.clienti);
			Integer index = this.clienti.indexOf(this.client);
			System.out.println(index);
			if((index + 1) < this.clienti.size()-1);
				this.client = this.clienti.get(index + 1);
		}
		
//adaugare
		
		public void adaugareClient(ActionEvent evt) {
			this.client = new Client();
			this.client.setIdClient(999);
			this.client.setNumeClient("Nume Client");
			this.client.setAdresa("Prenume Client");
			this.clienti.add(this.client);			
		}
		
//stergere
		
		public void stergereClient(ActionEvent evt) {
			this.clienti.remove(this.client);
			if(this.em.contains(this.client)) {
				this.em.getTransaction().begin();
				this.em.remove(this.client);
				this.em.getTransaction().commit();
			}
			if(!this.clienti.isEmpty())
				this.client = this.clienti.get(0);
			else
				this.client = null;
		}

//salvare
		
		public void salvareClient(ActionEvent evt) {
			System.out.println("Salvare");
			try {
				this.em.getTransaction().begin();
				this.em.merge(this.client);
				this.em.getTransaction().commit();
			}
			catch(Exception ex) {
				ex.getSuppressed();				
			}
			
		}
		
//abandon
		
		public void abandonClient(ActionEvent evt) {
			System.out.println("Abandon client!");
			em.clear();
			init();
		}
}	
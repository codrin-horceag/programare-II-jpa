package magazin;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		//Populare tabele
		
		LinkedList<Produse> catalog = new LinkedList<Produse>();
		CD backInBlack = new CD(1, "backinblack", "classic", "AC/DC", "Back In Black", 10, "Rock", false);
		CD whitePony = new CD(2, "whitepony", "masterpiece", "Deftones", "White Pony", 12, "Alternative Metal", false);
		CD nevermindDeluxe = new CD(3, "nevermind-deluxe", "classic", "Nirvana", "Nevermind (Deluxe Edition)", 40, "Grunge", true);
		CD animals = new CD(4, "animals", "underrated", "Pink Floyd", "Animals", 5, "Progressive Rock", false);
		CD dondaDeluxe = new CD(5, "donda-deluxe", "ye", "Kanye West", "Donda", 32, "Gospel Rap", true);
		
		Vinyl koiNoYokan = new Vinyl(6, "koinoyokan", "modern-masterpiece", "Deftones", "Koi No Yokan", 11, "Alternative Metal", "12'", 45);
		Vinyl wishYouWereHere = new Vinyl(7, "wishyouwerehere", "classic", "Pink Floyd", "Wish You Were Here", 5, "Progressive Rock", "12'", 45);
		Vinyl wildHoney = new Vinyl(8, "wildhoney", "cult-classic", "Tiamat", "Wildhoney", 10, "Doom/Goth Metal", "12'", 45);
		Vinyl sabbathBloodySabbath = new Vinyl(9, "sabbathbloodysabbath", "classic", "Black Sabbath", "Sabbath Bloody Sabbath", 8, "Heavy Metal", "12'", 45);
		Vinyl paranoid = new Vinyl(10, "paranoid", "classic", "Black Sabbath", "Paranoid", 8, "Heavy Metal", "12'", 45);
		
		Filme americanPsycho = new Filme(11, "americanpsycho", "classic", "Mary Harron", "1h 42m", "American Psycho", "Thriller");
		Filme fightClub = new Filme(12, "fightClub", "classic", "David Fincher", "2h 19m", "Fight Club", "Thriller/Drama");
		Filme drive = new Filme(13, "drive", "cult-classic", "Nicholas Winding Refn", "1h 40m", "Drive", "Action/Crime");
		
		catalog.add(drive);
		catalog.add(fightClub);
		catalog.add(americanPsycho);
		catalog.add(paranoid);
		catalog.add(sabbathBloodySabbath);
		catalog.add(wildHoney);
		catalog.add(wishYouWereHere);
		catalog.add(koiNoYokan);
		catalog.add(dondaDeluxe);
		catalog.add(animals);
		catalog.add(nevermindDeluxe);
		catalog.add(whitePony);
		catalog.add(backInBlack);
		
		Client client1 = new Client("Ryan Gosling", 1, "Secret");
		Client client2 = new Client("Codrin Horceag", 2, "Whatever Street, nr. 12");
		Client client3 = new Client("Freddy Krueger", 3, "Elm Street");
		
		LinkedList<Produse> ryansProducts = new LinkedList<Produse>();
		LinkedList<Produse> codrinsProducts	= new LinkedList<Produse>();
		LinkedList<Produse> freddysProducts	= new LinkedList<Produse>();
		
		ryansProducts.add(drive);
		ryansProducts.add(dondaDeluxe);
		ryansProducts.add(paranoid);
		
		codrinsProducts.add(americanPsycho);
		codrinsProducts.add(koiNoYokan);
		codrinsProducts.add(whitePony);
		codrinsProducts.add(animals);
		
		freddysProducts.add(fightClub);
		freddysProducts.add(sabbathBloodySabbath);
		freddysProducts.add(wildHoney);
		freddysProducts.add(nevermindDeluxe);
		freddysProducts.add(backInBlack);
		freddysProducts.add(wishYouWereHere);
		
		Biblioteca ryansBiblioteca = new Biblioteca(1, client1, ryansProducts);
		Biblioteca codrinsBiblioteca = new Biblioteca(2, client2, codrinsProducts);
		Biblioteca freddysBiblioteca = new Biblioteca(3, client3, freddysProducts);
		
		Angajat angajatSenior = new Angajat(1, 7);
		Angajat angajatMiddle = new Angajat(2, 3);
		Angajat angajatJunior = new Angajat(3, 1);
		
		LinkedList<Angajat> angajati = new LinkedList<Angajat>();
		
		angajati.add(angajatSenior);
		angajati.add(angajatMiddle);
		angajati.add(angajatJunior);
		
		LinkedList<Produse> stocDepozit = new LinkedList<Produse>();
		
		stocDepozit.addAll(catalog);
		
		Depozit depozit = new Depozit(1, "Deposit Street", angajati, stocDepozit);
		
		//Persistare
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProiectJPA");
		EntityManager em = emf.createEntityManager();
		
		//incepere tranzactie
		
		em.getTransaction().begin();
		
		//stergere date din tabele
		
		em.createQuery("DELETE FROM Produse").executeUpdate();
		em.createQuery("DELETE FROM Client").executeUpdate();
		em.createQuery("DELETE FROM Biblioteca").executeUpdate();
		em.createQuery("DELETE FROM Angajat").executeUpdate();
		em.createQuery("DELETE FROM Depozit").executeUpdate();
		
		//persistarea catalogului de produse
		
		for(int i = 0; i < catalog.size(); i++) {
			em.persist(catalog.get(i));
		}
		
		//persistarea clientilor
		
		em.persist(client1);
		em.persist(client2);
		em.persist(client3);
		
		//persistarea bibliotecilor fiecaruia
		
		em.persist(ryansBiblioteca);
		em.persist(codrinsBiblioteca);
		em.persist(freddysBiblioteca);
		
		//persistarea angajatilor
		
		for(int i = 0; i < angajati.size(); i++) {
			em.persist(angajati.get(i));
		}
		
		//persistarea depozitlui
		
		em.persist(depozit);
		
		//commit -- final tranzactie
		
		em.getTransaction().commit();
		
		//afisare intrari
		
		List<Produse> selectedProducts = em.createQuery("SELECT p FROM Produse p").getResultList();
		List<Client> selectedClients = em.createQuery("SELECT c FROM Client c").getResultList();
		List<Biblioteca> selectedLibraries = em.createQuery("SELECT b FROM Biblioteca b").getResultList();
		List<Angajat> selectedEmployees = em.createQuery("SELECT a FROM Angajat a").getResultList();
		List<Depozit> selectedDeposit = em.createQuery("SELECT d FROM Depozit d").getResultList();
		
		//afisare produse
		
		System.out.println();
		System.out.println("Produsele intrate in baza de date sunt: \n");
		
		for(Produse produs : selectedProducts) {
			System.out.println(produs);
		}
		
		System.out.println();
		
		//afisare clienti
		
		System.out.println("Clientii intrati in baza de date sunt: \n");
		
		for(Client c : selectedClients) {
			System.out.println(c);
		}
		
		System.out.println();
		
		//afisare biblioteci
		
		System.out.println("Bibliotecile intrate in baza de date sunt: \n");
		
		for(Biblioteca b : selectedLibraries) {
			System.out.println(b);
		}
		
		System.out.println();
		
		//afisare angajati
		
		System.out.println("Angajatii intrati in baza de date sunt: \n");
		
		for(Angajat a : selectedEmployees) {
			System.out.println(a);
		}
		
		System.out.println();
		
		//afisare depozit
		
		System.out.println("Depozitele intrate in baza de date sunt: \n");
		
		for(Depozit d : selectedDeposit) {
			System.out.println(d);
		}
		
		System.out.println();
	}
}

package magazin;
import java.util.LinkedList;

import javax.persistence.*;

@Entity
public class Depozit {
	
	@Id
	private int idDepozit;
	
	private String adresaDepozit;
	
	@OneToMany(mappedBy = "depozit")
	private LinkedList<Angajat> angajat = new LinkedList<Angajat>();
	
	@OneToMany(mappedBy = "depozit")
	private LinkedList<Produse> produse = new LinkedList<Produse>();
	
	
	public Depozit(int idDepozit, String adresaDepozit, LinkedList<Angajat> angajat, LinkedList<Produse> produse) {
		super();
		this.idDepozit = idDepozit;
		this.adresaDepozit = adresaDepozit;
		this.angajat = angajat;
		this.produse = produse;
	}



	public int getIdDepozit() {
		return idDepozit;
	}



	public void setIdDepozit(int idDepozit) {
		this.idDepozit = idDepozit;
	}



	public String getAdresaDepozit() {
		return adresaDepozit;
	}



	public void setAdresaDepozit(String adresaDepozit) {
		this.adresaDepozit = adresaDepozit;
	}



	public LinkedList<Angajat> getAngajat() {
		return angajat;
	}



	public void setAngajat(LinkedList<Angajat> angajat) {
		this.angajat = angajat;
	}



	public Depozit() {
		super();
	}



	@Override
	public String toString() {
		return "Depozit [idDepozit=" + idDepozit + ", adresaDepozit=" + adresaDepozit + ", angajat=" + angajat
				+ ", produse=" + produse + "]";
	}
	
	
   
}

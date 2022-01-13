package magazin;
import javax.persistence.*;

@Entity
public class Angajat {

	@Id
	private int idAngajat;
	private int aniExperienta;
	private String pozitie;
	
	@ManyToOne
	private Depozit depozit;
	
	

	public Angajat(int idAngajat, int aniExperienta) {
		super();
		this.idAngajat = idAngajat;
		this.aniExperienta = aniExperienta;
		
		if(aniExperienta <= 2) {
			this.pozitie = "Junior";
		} else if(aniExperienta >= 2 && aniExperienta <= 4) {
			this.pozitie = "Middle";
		} else {
			this.pozitie = "Senior";
		}
	}



	public int getIdAngajat() {
		return idAngajat;
	}



	public void setIdAngajat(int idAngajat) {
		this.idAngajat = idAngajat;
	}



	public int getAniExperienta() {
		return aniExperienta;
	}



	public void setAniExperienta(int aniExperienta) {
		this.aniExperienta = aniExperienta;
	}



	public String getPozitie() {
		return pozitie;
	}



	public void setPozitie(String pozitie) {
		this.pozitie = pozitie;
	}



	public Depozit getDepozit() {
		return depozit;
	}



	public void setDepozit(Depozit depozit) {
		this.depozit = depozit;
	}



	public Angajat() {
		super();
	}



	@Override
	public String toString() {
		return "Angajat [idAngajat=" + idAngajat + ", aniExperienta=" + aniExperienta + ", pozitie=" + pozitie
				+ ", depozit=" + depozit + "]";
	}
	
	
   
}

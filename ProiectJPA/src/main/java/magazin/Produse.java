package magazin;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

import java.util.Objects;

@Entity
public abstract class Produse {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idProdus;
    private String nume;
    private String descriere;
    
    @ManyToOne
    private Biblioteca biblioteca;
    
    @ManyToOne
    private Depozit depozit;

    public Produse(Integer idProdus, String nume, String descriere) {
        this.idProdus = idProdus;
        this.nume = nume;
        this.descriere = descriere;
    }

    public Produse() {

    }

    public Integer getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(Integer idProdus) {
        this.idProdus = idProdus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public Depozit getDepozit() {
		return depozit;
	}

	public void setDepozit(Depozit depozit) {
		this.depozit = depozit;
	}

	@Override
    public String toString() {
        return "idProdus=" + idProdus +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\''
                ;
    }

	@Override
	public int hashCode() {
		return Objects.hash(biblioteca, descriere, idProdus, nume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produse other = (Produse) obj;
		return Objects.equals(biblioteca, other.biblioteca) && Objects.equals(descriere, other.descriere)
				&& Objects.equals(idProdus, other.idProdus) && Objects.equals(nume, other.nume);
	}
	
	
}

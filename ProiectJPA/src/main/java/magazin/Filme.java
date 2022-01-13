package magazin;
import javax.persistence.Entity;

@Entity
public class Filme extends Produse{
	private String regizor;
    private String durata;
    private String titlu;
    private String genFilm;

    public Filme(Integer idProdus, String nume, String descriere, String regizor, String durata, String titlu, String genFilm) {
        super(idProdus, nume, descriere);
        this.regizor = regizor;
        this.durata = durata;
        this.titlu = titlu;
        this.genFilm = genFilm;
    }
    
    public Filme() {
    	super();
    }

    public String getRegizor() {
        return regizor;
    }

    public void setRegizor(String regizor) {
        this.regizor = regizor;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getGenFilm() {
        return genFilm;
    }

    public void setGenFilm(String genFilm) {
        this.genFilm = genFilm;
    }

    @Override
    public String toString() {
        return   super.toString() +
                ", regizor='" + regizor + '\'' +
                ", durata='" + durata + '\'' +
                ", titlu='" + titlu + '\'' +
                ", genFilm='" + genFilm + '\''
                ;
    }
}

package magazin;
import javax.persistence.Entity;

@Entity
public abstract class Muzica extends Produse {
	private String artist;
    private String titluAlbum;
    private Integer nrMelodii;
    private String genMuzical;

    public Muzica() {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitluAlbum() {
        return titluAlbum;
    }

    public void setTitluAlbum(String titluAlbum) {
        this.titluAlbum = titluAlbum;
    }

    public Integer getNrMelodii() {
        return nrMelodii;
    }

    public void setNrMelodii(Integer nrMelodii) {
        this.nrMelodii = nrMelodii;
    }

    public String getGenMuzical() {
        return genMuzical;
    }

    public void setGenMuzical(String genMuzical) {
        this.genMuzical = genMuzical;
    }

    public Muzica(Integer idProdus, String nume, String descriere, String artist, String titluAlbum, Integer nrMelodii, String genMuzical) {
        super(idProdus, nume, descriere); 
        this.artist = artist;
        this.titluAlbum = titluAlbum;
        this.nrMelodii = nrMelodii;
        this.genMuzical = genMuzical;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", artist='" + artist + '\'' +
                ", titluAlbum='" + titluAlbum + '\'' +
                ", nrMelodii=" + nrMelodii + '\'' +
                ", genMuzical=" + genMuzical + '\''
                ;
    }
}

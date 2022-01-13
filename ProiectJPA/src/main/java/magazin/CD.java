package magazin;
import javax.persistence.Entity;

@Entity
public class CD extends Muzica{
	private String tipCutie;
    private boolean isDoubleDisk;

    public CD(Integer idProdus, String nume, String descriere, String artist, String titluAlbum, Integer nrMelodii, String genMuzical, boolean isDoubleDisk) {
        super(idProdus, nume, descriere, artist, titluAlbum, nrMelodii, genMuzical);
        this.isDoubleDisk = isDoubleDisk;
        if(isDoubleDisk) {
            this.tipCutie = "Steelbook";
        } else {
            this.tipCutie = "Plastic";
        }
    }

    public CD() {
        super();
    }

    public String getTipCutie() {
        return tipCutie;
    }

    public void setTipCutie(String tipCutie) {
        this.tipCutie = tipCutie;
    }



    public boolean isDoubleDisk() {
        return isDoubleDisk;
    }

    public void setDoubleDisk(boolean doubleDisk) {
        isDoubleDisk = doubleDisk;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", tipCutie='" + tipCutie + '\'' +
                ", isDoubleDisk=" + isDoubleDisk
                ;
    }
}

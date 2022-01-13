package magazin;
import javax.persistence.Entity;

@Entity
public class Vinyl extends Muzica{
	private String format;
    private int rpm;

    public Vinyl(Integer idProdus, String nume, String descriere, String artist, String titluAlbum, Integer nrMelodii, String genMuzical, String format, int rpm) {
        super(idProdus, nume, descriere, artist, titluAlbum, nrMelodii, genMuzical);
        this.format = format;
        this.rpm = rpm;
    }
    
    public Vinyl() {
    	
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", format='" + format + '\'' +
                ", rpm=" + rpm
                ;
    }
}

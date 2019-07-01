package cs.mum.edu.inheritance;

import javax.persistence.Entity;

@Entity
public class CD extends Product {
    private String artist;

    public CD(){
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

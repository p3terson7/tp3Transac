package ca.cal.tp3.model;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("LIVRE")
@Table

public class Livre extends Document {
    @Transient
    private final int EMPRUNT_DUREE = 7;
    private String editeur;
    private int nbPages;
    private String genre;
    @Override
    public int getEmpruntDuree() {
        return EMPRUNT_DUREE;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "EMPRUNT_DUREE=" + EMPRUNT_DUREE +
                ", editeur='" + editeur + '\'' +
                ", nbPages=" + nbPages +
                ", genre='" + genre + '\'' +
                ", Id=" + Id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", annee=" + annee +
                ", nbCopies=" + nbCopies +
                '}';
    }

    public void setEmpruntDuree(int empruntDuree) {
    }
}

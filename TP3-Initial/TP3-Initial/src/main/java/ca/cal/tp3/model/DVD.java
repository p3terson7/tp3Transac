package ca.cal.tp3.model;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("DVD")
@Table

public class DVD extends Document {
    @Transient
    private final int EMPRUNT_DUREE = 7;
    private int duree;
    @Override
    public int getEmpruntDuree() {
        return EMPRUNT_DUREE;
    }
    public void setEmpruntDuree(int empruntDuree) {
    }
}

package ca.cal.tp3.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("CLIENT")
@Table(name = "CLIENT")
public class Client extends Utilisateur {
    @OneToMany(mappedBy = "client")
    @Builder.Default
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @Builder.Default
    private List<Amende> amendes = new ArrayList<>();

    public Emprunt getEmprunt(long id) {
        for (Emprunt e : emprunts) {
            if (e.getDocument().getId() == id && !e.isEmpruntReturned()) {
                return e;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "Client{" +
                "emprunts=" + emprunts +
                ", amendes=" + amendes +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

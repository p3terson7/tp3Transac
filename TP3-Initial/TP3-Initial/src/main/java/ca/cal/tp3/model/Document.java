package ca.cal.tp3.model;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "doc_type")
@Table

public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long Id;
    protected String titre;
    protected String auteur;
    protected int annee;
    protected int nbCopies;

    public abstract int getEmpruntDuree();
}

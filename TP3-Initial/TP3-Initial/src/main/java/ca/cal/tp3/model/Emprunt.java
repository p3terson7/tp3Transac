package ca.cal.tp3.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table

public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Client client;
    @OneToOne
    private Document document;
    private LocalDate empruntDate;
    private LocalDate empruntDateEcheance;
    private boolean empruntReturned;

}

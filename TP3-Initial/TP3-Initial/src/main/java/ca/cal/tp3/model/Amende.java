package ca.cal.tp3.model;

import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table

public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Client client;
    private double amendeCout;
    public boolean amendePaid;

    @Override
    public String toString() {
        return "Amende{" +
                "id=" + id +
                ", client=" + client +
                ", amendeCout=" + amendeCout +
                ", amendePaid=" + amendePaid +
                '}';
    }
}

package ca.cal.tp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpruntDTO {
    private long id;
    private long cltId;
    private long docId;
    private LocalDate empruntDate;
    private LocalDate emprunteDateEcheance;
    private boolean empruntReturned;

}

package ca.cal.tp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CdDTO {
    private long id;
    private String titre;
    private String auteur;
    private int annee;
    private int nbCopies;
    private int duree;
}

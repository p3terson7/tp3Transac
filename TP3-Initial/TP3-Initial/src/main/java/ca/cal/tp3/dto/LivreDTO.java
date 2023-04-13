package ca.cal.tp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LivreDTO {
    private long id;
    private String titre;
    private String auteur;
    private int annee;
    private int nbCopies;
    private String editeur;
    private int nbPages;
    private String genre;
}

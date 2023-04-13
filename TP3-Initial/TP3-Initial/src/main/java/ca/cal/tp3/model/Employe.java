package ca.cal.tp3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("EMPLOYE")
@Table

public class Employe extends Utilisateur{
}

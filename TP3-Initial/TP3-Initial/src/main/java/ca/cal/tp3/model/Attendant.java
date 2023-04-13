package ca.cal.tp3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ATTENDANT")
@Table

public class Attendant extends Utilisateur{
}

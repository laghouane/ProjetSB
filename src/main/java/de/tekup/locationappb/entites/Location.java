package de.tekup.locationappb.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dateDebut;

    private LocalDate dateRetour;

    private double prixJour;
    @Transient
    private double prix;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Voiture voiture;
    @PostLoad
    private void calculatePrix(){
        long nbJour = ChronoUnit.DAYS.between(dateDebut,dateRetour)+1;
        prix = prixJour * nbJour;
    }
}

package de.tekup.locationappb.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonIdentityInfo(property = "model",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String serie;

    @PastOrPresent
    private LocalDate dateDeMiseEnMarche;

    @NotBlank
    private String model;
    @NotBlank
    private String vendor;
    @Positive
    private double prixDeJour;

    private String imagePath;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;



    public String getDateHTML() {
        return dateDeMiseEnMarche==null?"":dateDeMiseEnMarche.toString();
    }

    public void setDateHTML(String dateHTML) {
        this.dateDeMiseEnMarche = LocalDate.parse(dateHTML);
    }

    public Voiture(String serie, LocalDate dateDeMiseEnMarche, String model) {
        this.serie = serie;
        this.dateDeMiseEnMarche = dateDeMiseEnMarche;
        this.model = model;
    }
}

package de.tekup.locationappb.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(property = "cin",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,length = 8)
    @Pattern(regexp = "^[0-9]{8}$", message = "CIN must contains exactly 8 digits")
    private String cin;
    @Column(length = 50)
    @NotBlank
    @Size(min=3,max = 50)
    private String nom;
    @Column(length = 50)
    @Size(min=3,max = 50)
    private String prenom;

    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;

    public Client(String cin, String nom, String prenom, String adresse) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
}

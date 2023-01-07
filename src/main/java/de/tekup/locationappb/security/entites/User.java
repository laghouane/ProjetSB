package de.tekup.locationappb.security.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(unique = true)
    @NotBlank
    private String username;
    @Email
    private String email;
    @Size(min = 4)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}

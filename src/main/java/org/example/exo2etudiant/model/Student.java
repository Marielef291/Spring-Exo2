package org.example.exo2etudiant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ce champ doit être rempli !")
    private String lastname; //nom de famille

    @NotBlank(message = "Ce champ doit être rempli !")
    private String firstname; //prénom

    @NotBlank(message = "Ce champ doit être rempli !")
    @Email
    private String email;

    @Min(11)
    @Max(20)
    private int age;
}

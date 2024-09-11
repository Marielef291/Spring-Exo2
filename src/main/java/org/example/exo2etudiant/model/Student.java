package org.example.exo2etudiant.model;

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
public class Student {

    private UUID id;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @NotNull(message = "Ce champ doit être rempli !")
    private String lastname;

    @NotNull(message = "Ce champ doit être rempli !")
    private String firstname;

    @NotNull(message = "Ce champ doit être rempli !")
    @Email
    private String email;

//    @NotNull(message = "Ce champ doit être rempli !")
//    @Min(11)
//    @Max(20)
    private int age;
}

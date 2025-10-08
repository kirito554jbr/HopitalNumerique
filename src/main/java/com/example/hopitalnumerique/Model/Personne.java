package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String password;

}

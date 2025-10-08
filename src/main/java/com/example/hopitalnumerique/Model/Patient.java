package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "patient")
public class Patient extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient;
    private float poids;
    private float taille;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;


    public Patient(String nom, String prenom, String email, String password, int idPatient, float poids, float taille, List<Consultation> consultations) {
        super(nom, prenom, email, password);
        this.idPatient = idPatient;
        this.poids = poids;
        this.taille = taille;
        this.consultations = consultations;
    }

}

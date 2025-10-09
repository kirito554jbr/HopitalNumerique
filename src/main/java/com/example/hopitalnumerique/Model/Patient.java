package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "patient")
public class Patient extends Personne{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int idPatient;
    private float poids;
    private float taille;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Consultation> consultations;



    public Patient(int id,String nom, String prenom, String email, String password,  float poids, float taille, List<Consultation> consultations) {
        super(id,nom, prenom, email, password);
//        this.idPatient = idPatient;
        this.poids = poids;
        this.taille = taille;
        this.consultations = consultations;
    }

}

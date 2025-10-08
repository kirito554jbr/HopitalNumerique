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
@Table(name = "docteur")
public class Docteur extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoecteur;
    private String specialite;
    @ManyToOne
    private Department department;
    @OneToMany
    private List<Consultation> planing;



    public Docteur(String nom, String prenom, String email, String password, int idDoecteur, String specialite, Department department, List<Consultation> planing) {
        super(nom, prenom, email, password);
        this.idDoecteur = idDoecteur;
        this.specialite = specialite;
        this.department = department;
        this.planing = planing;
    }

}

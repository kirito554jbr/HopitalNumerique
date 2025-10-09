package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "docteur")
public class Docteur extends Personne {

    private String specialite;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_idDepartment")
    @ToString.Exclude
    private Department department;

    @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Consultation> planing = new ArrayList<>();


    public Docteur(String nom, String prenom, String email, String password,
                   String specialite, Department department, List<Consultation> planing) {
        super(nom, prenom, email, password);
        this.specialite = specialite;
        this.department = department;
        this.planing = planing;
    }
}
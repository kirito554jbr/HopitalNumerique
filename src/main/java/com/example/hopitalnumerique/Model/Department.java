package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;

    private String nom;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Docteur> docteurs;

    public Department(String nom) {
        this.nom = nom;
    }

}

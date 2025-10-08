package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;

    private String nom;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Docteur> docteurs;

    public Department() {}

    public Department(int idDepartment, String nom, List<Docteur> docteurs) {
        this.idDepartment = idDepartment;
        this.nom = nom;
        this.docteurs = docteurs;
    }

    public Department(String nom) {
        this.nom = nom;
    }


    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Docteur> getDocteurs() {
        return docteurs;
    }

    public void setDocteurs(List<Docteur> docteurs) {
        this.docteurs = docteurs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nom='" + nom + '\'' +
                ", docteurs=" + docteurs +
                '}';
    }
}

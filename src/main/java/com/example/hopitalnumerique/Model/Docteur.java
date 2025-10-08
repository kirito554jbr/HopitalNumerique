package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

import java.util.List;

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

    public Docteur() {
        super();
    }


    public int getIdDoecteur() {
        return idDoecteur;
    }

    public void setIdDoecteur(int idDoecteur) {
        this.idDoecteur = idDoecteur;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Consultation> getPlaning() {
        return planing;
    }

    public void setPlaning(List<Consultation> planing) {
        this.planing = planing;
    }

    @Override
    public String toString() {
        return "Docteur{" +
                "idDoecteur=" + idDoecteur +
                ", specialite='" + specialite + '\'' +
                ", department=" + department +
                ", planing=" + planing +
                '}';
    }
}

package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

import java.util.List;

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

    public Patient(int idPatient, float poids, float taille, List<Consultation> consultations) {
        this.idPatient = idPatient;
        this.poids = poids;
        this.taille = taille;
        this.consultations = consultations;
    }

    public Patient() {

    }


    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", poids=" + poids +
                ", taille=" + taille +
                ", consultations=" + consultations +
                '}';
    }
}

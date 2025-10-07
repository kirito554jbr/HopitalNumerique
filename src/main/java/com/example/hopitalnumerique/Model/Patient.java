package com.example.hopitalnumerique.Model;

public class Patient extends Personne{

    private long idPatient;
    private float poids;
    private float taille;
//    private


    public Patient(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }
}

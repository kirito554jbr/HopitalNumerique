package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultaion")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsultation;
    private LocalDate date;
    private LocalDateTime heure;
    private Enum<Status> status;
    private String compteRendu;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Docteur docteur;
    @ManyToOne
    private Salle salle;


    public Consultation(int idConsultation, LocalDate date, LocalDateTime heure, Enum<Status> status, String compteRendu, Patient patient, Docteur docteur, Salle salle) {
        this.idConsultation = idConsultation;
        this.date = date;
        this.heure = heure;
        this.status = status;
        this.compteRendu = compteRendu;
        this.patient = patient;
        this.docteur = docteur;
        this.salle = salle;
    }

    public Consultation() {

    }


    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }

    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Enum<Status> status) {
        this.status = status;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Docteur getDocteur() {
        return docteur;
    }

    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }


    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", date=" + date +
                ", heure=" + heure +
                ", status=" + status +
                ", compteRendu='" + compteRendu + '\'' +
                ", patient=" + patient +
                ", docteur=" + docteur +
                ", salle=" + salle +
                '}';
    }
}

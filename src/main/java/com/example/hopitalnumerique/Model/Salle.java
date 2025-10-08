package com.example.hopitalnumerique.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalle;

    private String nomSalle;
    private int capacite;

    @ElementCollection
    private List<LocalDate> creneaux_occupes;

    public Salle() {}

    public Salle(int idSalle, String nomSalle, int capacite, List<LocalDate> creneaux_occupes) {
        this.idSalle = idSalle;
        this.nomSalle = nomSalle;
        this.capacite = capacite;
        this.creneaux_occupes = creneaux_occupes;
    }
    public Salle(String nomSalle, int capacite) {
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }



    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<LocalDate> getCreneaux_occupes() {
        return creneaux_occupes;
    }

    public void setCreneaux_occupes(List<LocalDate> creneaux_occupes) {
        this.creneaux_occupes = creneaux_occupes;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "idSalle=" + idSalle +
                ", nomSalle='" + nomSalle + '\'' +
                ", capacite=" + capacite +
                ", creneaux_occupes=" + creneaux_occupes +
                '}';
    }
}

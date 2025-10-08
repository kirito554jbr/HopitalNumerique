package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
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

}

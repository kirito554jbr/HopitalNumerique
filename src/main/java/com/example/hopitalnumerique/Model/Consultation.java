package com.example.hopitalnumerique.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsultation;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private LocalDateTime heure;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String compteRendu;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @ToString.Exclude
    private Patient patient;
    @ManyToOne
    @ToString.Exclude
    private Docteur docteur;
    @ManyToOne
    private Salle salle;

}

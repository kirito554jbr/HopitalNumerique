package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Consultation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface IConsultationRepository {
    void create(Consultation consultation);
    Consultation read(int id);
    List<Consultation> readAll();
    void update(Consultation consultation, int id);
    void delete(int id);
    boolean existsByDocteurAndDateHeure(int docteurId, LocalDate date, LocalDateTime heure);
    boolean existsBySalleAndDateHeure(int salleId, LocalDate date, LocalDateTime heure);
}

package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Consultation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface IConsultationService {

    void create(Consultation consultation);
    Consultation read(int id);
    List<Consultation> readAll();
    void update(Consultation consultation, int id);
    void delete(int id);
    void CancelConsultation(int id);
}

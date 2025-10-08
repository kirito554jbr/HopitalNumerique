package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Consultation;

import java.util.List;

public interface IConsultationRepository {
    void create(Consultation consultation);
    Consultation read(int id);
    List<Consultation> readAll();
    void update(Consultation consultation, int id);
    void delete(int id);
}

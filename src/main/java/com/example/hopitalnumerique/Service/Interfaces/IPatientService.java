package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Patient;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IPatientService {
    void create(Patient patient);
    Patient read(int id);
    List<Patient> readAll();
    void update(Patient patient, int id);
    void delete(int id);
}

package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Patient;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IPatientRepository {
    void create(Patient patient);
    Patient read(int id);
    List<Patient> readAll();
    void update(Patient patient, int id);
    void delete(int id);
    Patient readByNomPatient(String nom);
    List<Patient> getByDocteur(String docteur);
    Patient findByEmail(String email);
}

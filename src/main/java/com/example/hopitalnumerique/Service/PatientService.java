package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Patient;
import com.example.hopitalnumerique.Repository.Interfaces.IPatientRepository;
import com.example.hopitalnumerique.Service.Interfaces.IPatientService;

import java.util.List;

public class PatientService implements IPatientService {
    private IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void create(Patient patient) {
        this.patientRepository.create(patient);
    }

    @Override
    public Patient read(int id) {
        return this.patientRepository.read(id);
    }

    @Override
    public List<Patient> readAll() {
        return this.patientRepository.readAll();
    }

    @Override
    public void update(Patient patient, int id) {
        this.patientRepository.update(patient, id);
    }

    @Override
    public void delete(int id) {
        this.patientRepository.delete(id);
    }
}

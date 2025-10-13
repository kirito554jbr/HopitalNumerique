package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Patient;
import com.example.hopitalnumerique.Repository.Interfaces.IPatientRepository;
import com.example.hopitalnumerique.Service.Interfaces.IPatientService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

public class PatientService implements IPatientService {
    private IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void create(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }

        // Validate required string fields
        if (isNullOrEmpty(patient.getNom()) ||
                isNullOrEmpty(patient.getPrenom()) ||
                isNullOrEmpty(patient.getEmail()) ||
                isNullOrEmpty(patient.getPassword())) {
            throw new IllegalArgumentException("All required patient fields must be provided (nom, prenom, email, password).");
        }

        // Validate numeric fields (if using Float wrapper type)
        if (patient.getPoids() <= 0 || patient.getPoids() <= 0) {
            throw new IllegalArgumentException("Patient weight must be a positive value.");
        }
        if (patient.getTaille() <= 0 || patient.getTaille() <= 0) {
            throw new IllegalArgumentException("Patient height must be a positive value.");
        }

        // check if email already exists
        Patient existing = patientRepository.readByNomPatient(patient.getEmail());
        if (existing != null) {
            throw new IllegalStateException("A patient with this email already exists.");
        }
        this.patientRepository.create(patient);
    }



    @Override
    public Patient read(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du patient doit être positif.");
        }
        Patient patient = this.patientRepository.read(id);
        if (patient == null) {
            throw new NoSuchElementException("Aucun patient trouvé avec l'identifiant : " + id);
        }
        return patient;
    }

    @Override
    public List<Patient> readAll() {
        return this.patientRepository.readAll();
    }

    @Override
    public void update(Patient patient, int id) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }

        // Check if patient exists
        Patient existingPatient = patientRepository.read(id);
        if (existingPatient == null) {
            throw new EntityNotFoundException("Patient with ID " + id + " not found.");
        }

        // Validate required string fields
        if (isNullOrEmpty(patient.getNom()) ||
                isNullOrEmpty(patient.getPrenom()) ||
                isNullOrEmpty(patient.getEmail())) {
            throw new IllegalArgumentException("Patient name, surname, and email cannot be null or empty.");
        }

        // Validate numeric fields
        if (patient.getPoids() <= 0) {
            throw new IllegalArgumentException("Patient weight must be a positive value.");
        }

        if (patient.getTaille() <= 0) {
            throw new IllegalArgumentException("Patient height must be a positive value.");
        }

        // Optional: check for duplicate email (if changed)
        Patient duplicate = patientRepository.readByNomPatient(patient.getEmail());
        if (duplicate != null && duplicate.getId() != id) {
            throw new IllegalStateException("A patient with this email already exists.");
        }

        // Save changes
        patientRepository.update(existingPatient, id);
    }



    @Override
    public void delete(int id) {
        if (id == 0 || id < 1) {
            throw new IllegalArgumentException("Patient id must be a positive value.");
        }
        if (patientRepository.read(id) == null) {
            throw new EntityNotFoundException("Patient with ID " + id + " not found.");
        }
        this.patientRepository.delete(id);
    }

    @Override
    public boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

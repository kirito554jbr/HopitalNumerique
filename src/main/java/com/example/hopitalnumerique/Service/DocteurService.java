package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Repository.Interfaces.IDocteurRepository;
import com.example.hopitalnumerique.Service.Interfaces.IDocteurService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

public class DocteurService implements IDocteurService {
    private IDocteurRepository docteurRepository;

    public DocteurService(IDocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }

    public void create(Docteur docteur) {

        if (docteur.getNom() == null || docteur.getPrenom() == null ||
                docteur.getEmail() == null || docteur.getPassword() == null ||
                docteur.getDepartment() == null || docteur.getSpecialite() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires doivent être remplis.");
        }

        // Normalize data (e.g., trim spaces, standardize email)
        docteur.setNom(docteur.getNom().trim());
        docteur.setPrenom(docteur.getPrenom().trim());
        docteur.setEmail(docteur.getEmail().trim().toLowerCase());

        // Check if email already exists
        if (docteurRepository.findByEmail(docteur.getEmail()) != null) {
            throw new IllegalArgumentException("Un docteur avec cet email existe déjà.");
        }
        this.docteurRepository.create(docteur);
    }


    @Override
    public Docteur read(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du docteur doit être positif.");
        }
        Docteur docteur = this.docteurRepository.read(id);


        if (docteur == null) {
            throw new NoSuchElementException("Aucun docteur trouvé avec l'identifiant : " + id);
        }
        return docteur;
    }


    @Override
    public List<Docteur> readAll() {
        return this.docteurRepository.readAll();
    }

    @Override
    public void update(Docteur docteur, int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du docteur doit être positif.");
        }


        Docteur existing = this.docteurRepository.read(id);
        if (existing == null) {
            throw new NoSuchElementException("Aucun docteur trouvé avec l'identifiant : " + id);
        }


        // 4️ Validate and normalize new data
        if (docteur.getEmail() != null) {
            docteur.setEmail(docteur.getEmail().trim().toLowerCase());

            // Check for email uniqueness
            Docteur existingEmail = this.docteurRepository.findByEmail(docteur.getEmail());
            if (existingEmail != null && existingEmail.getId() != id) {
                throw new IllegalArgumentException("L'email est déjà utilisé par un autre docteur.");
            }
        }


        if (docteur.getPassword() == null || docteur.getPassword().isBlank()) {
            docteur.setPassword(existing.getPassword());
        }

        this.docteurRepository.update(docteur, id);
    }


    @Override
    public void delete(int id) {
        if (id == 0 || id < 1) {
            throw new IllegalArgumentException("Docteur id must be a positive value.");
        }
        if (docteurRepository.read(id) == null) {
            throw new EntityNotFoundException("Docteur with ID " + id + " not found.");
        }
        this.docteurRepository.delete(id);
    }
}

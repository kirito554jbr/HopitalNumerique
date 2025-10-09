package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Service.Interfaces.ISalleService;

import java.util.List;

public class SalleService implements ISalleService {

    private ISalleRepository salleRepository;

    public SalleService(ISalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public void create(Salle salle) throws Exception {
        try {
            // Validate input is not null
            if (salle == null) {
                throw new IllegalArgumentException("La salle ne peut pas être null");
            }

            // Validate room name
            if (salle.getNomSalle() == null || salle.getNomSalle().trim().isEmpty()) {
                throw new IllegalArgumentException("Le nom de la salle est obligatoire");
            }

            // Validate capacity
            if (salle.getCapacite() <= 0) {
                throw new IllegalArgumentException("La capacité doit être supérieure à 0");
            }


            // Check for duplicate room name
            if (this.salleRepository.existsByNomSalle(salle.getNomSalle())) {
                throw new IllegalArgumentException("Une salle avec ce nom existe déjà");
            }

            // Normalize room name (trim whitespace, capitalize)
            salle.setNomSalle(salle.getNomSalle().trim());


            // Create the room
            this.salleRepository.create(salle);

        } catch (IllegalArgumentException e) {
            // Log the validation error
            System.err.println("Erreur de validation: " + e.getMessage());
            throw e;

        } catch (Exception e) {
            // Log unexpected errors
            System.err.println("Erreur lors de la création de la salle: " + e.getMessage());
            throw new Exception("Impossible de créer la salle: " + e.getMessage(), e);
        }
    }

    @Override
    public Salle read(int id) {
        return this.salleRepository.read(id);
    }

    @Override
    public List<Salle> readAll() {
        return this.salleRepository.readAll();
    }

    @Override
    public void update(Salle salle, int id) {
        this.salleRepository.update(salle, id);
    }

    @Override
    public void delete(int id) {
        this.salleRepository.delete(id);
    }
}

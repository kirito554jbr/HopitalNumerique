package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Service.Interfaces.ISalleService;

import java.util.List;

public class SalleService implements ISalleService {

    private final ISalleRepository salleRepository;

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
    public Salle read(int id) throws IllegalArgumentException {
         if (id <= 0) {
             return null;
         }

        Salle salle = this.salleRepository.read(id);

         if(salle == null){
             throw new IllegalArgumentException("Une salle avec ce nom existe pas");
         }
        return salle;
    }

    @Override
    public List<Salle> readAll() throws IllegalArgumentException {
        List<Salle> salles = this.salleRepository.readAll();
        if (salles == null || salles.isEmpty()) {
            throw new IllegalArgumentException("no salles existe ");
        }
        return salles;
    }

    @Override
    public void update(Salle salle, int id) throws Exception {
        try {
            // Validate input parameters
            if (salle == null) {
                throw new IllegalArgumentException("La salle ne peut pas être null");
            }

            if (id <= 0) {
                throw new IllegalArgumentException("L'ID de la salle doit être valide");
            }

            // Check if the room exists
            Salle existingSalle = this.salleRepository.read(id);
            if (existingSalle == null) {
                throw new IllegalArgumentException("La salle avec l'ID " + id + " n'existe pas");
            }

            // Validate room name
            if (salle.getNomSalle() == null || salle.getNomSalle().trim().isEmpty()) {
                throw new IllegalArgumentException("Le nom de la salle est obligatoire");
            }

            // Validate capacity
            if (salle.getCapacite() <= 0) {
                throw new IllegalArgumentException("La capacité doit être supérieure à 0");
            }

    //            // Check for duplicate room name (excluding current room)
    //            if (this.salleRepository.existsByNomSalle(salle.getNomSalle())) {
    //                throw new IllegalArgumentException("Une autre salle avec ce nom existe déjà");
    //            }

            // Business rule: If capacity is reduced, check for existing reservations
//            if (salle.getCapacite() < existingSalle.getCapacite()) {
//                boolean hasLargeReservations = this.salleRepository.hasReservationsExceedingCapacity(id, salle.getCapacite());
//                if (hasLargeReservations) {
//                    throw new IllegalArgumentException(
//                            "Impossible de réduire la capacité. Des réservations existantes dépassent la nouvelle capacité"
//                    );
//                }
//            }

            // Business rule: Cannot modify a room that has active reservations if changing critical fields
//            if (!existingSalle.getNomSalle().equals(salle.getNomSalle())) {
//                boolean hasActiveReservations = this.salleRepository.hasActiveReservations(id);
//                if (hasActiveReservations) {
//                    throw new IllegalArgumentException(
//                            "Impossible de modifier le nom. La salle a des réservations actives"
//                    );
//                }
//            }

            // Normalize room name
            salle.setNomSalle(salle.getNomSalle().trim());


            // Preserve ID to ensure consistency
            salle.setIdSalle(id);

            // Update the room
            this.salleRepository.update(salle, id);

        } catch (IllegalArgumentException e) {
            // Log validation error
            System.err.println("Erreur de validation lors de la mise à jour: " + e.getMessage());
            throw e;

        } catch (Exception e) {
            // Log unexpected errors
            System.err.println("Erreur lors de la mise à jour de la salle: " + e.getMessage());
            throw new Exception("Impossible de mettre à jour la salle: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            return;
        }

        this.salleRepository.delete(id);
    }
}

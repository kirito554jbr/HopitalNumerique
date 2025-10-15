package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Consultation;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Status;
import com.example.hopitalnumerique.Repository.Interfaces.IConsultationRepository;
import com.example.hopitalnumerique.Service.Interfaces.IConsultationService;

import java.rmi.server.ObjID;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultationService implements IConsultationService {
    private IConsultationRepository consultationRepository;

    public ConsultationService(IConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void create(Consultation consultation) {
        // Validate required fields
        if (consultation.getDate() == null ||
                consultation.getHeure() == null ||
                consultation.getStatus() == null ||
                consultation.getCompteRendu() == null ||
                consultation.getPatient() == null ||
                consultation.getDocteur() == null ||
                consultation.getSalle() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires de la consultation doivent être renseignés.");
        }



        if (consultation.getDocteur() == null) {
            throw new IllegalArgumentException("Le docteur associé à la consultation est invalide.");
        }

        if (consultation.getPatient() == null) {
            throw new IllegalArgumentException("Le patient associé à la consultation est invalide.");
        }

        //  Check for scheduling conflicts (doctor or room already booked)
        boolean docteurBusy = consultationRepository.existsByDocteurAndDateHeure(
                consultation.getDocteur().getId(), consultation.getDate(), consultation.getHeure());
        if (docteurBusy) {
            throw new IllegalStateException("Le docteur a déjà une consultation prévue à cette heure.");
        }

        boolean salleOccupee = consultationRepository.existsBySalleAndDateHeure(
                consultation.getSalle().getIdSalle(), consultation.getDate(), consultation.getHeure());
        if (salleOccupee) {
            throw new IllegalStateException("La salle est déjà réservée à cette heure.");
        }

        // Set default values
        if (consultation.getStatus() == null) {
            consultation.setStatus(Status.RESERVEE);
        }

        // Save consultation
        this.consultationRepository.create(consultation);
    }


    @Override
    public Consultation read(int id) {
        if(id == 0 || id < 1){
            throw new IllegalArgumentException("Le id est invalide.");
        }
        Consultation consultation = this.consultationRepository.read(id);
        if (consultation == null) {
            throw new IllegalArgumentException("Le consultation est invalide.");
        }
        return consultation;
    }

    @Override
    public List<Consultation> readAll() {
        return this.consultationRepository.readAll();
    }

    @Override
    public void update(Consultation consultation, int id) {
        if (consultation.getDate() == null ||
                consultation.getHeure() == null ||
                consultation.getStatus() == null ||
                consultation.getPatient() == null ||
                consultation.getDocteur() == null ||
                consultation.getSalle() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires de la consultation doivent être renseignés.");
        }

        if (consultation.getDocteur() == null) {
            throw new IllegalArgumentException("Le docteur associé à la consultation est invalide.");
        }

        if (consultation.getPatient() == null) {
            throw new IllegalArgumentException("Le patient associé à la consultation est invalide.");
        }


        boolean docteurBusy = consultationRepository.existsByDocteurAndDateHeure(
                consultation.getDocteur().getId(), consultation.getDate(), consultation.getHeure());
        if (docteurBusy) {
            throw new IllegalStateException("Le docteur a déjà une consultation prévue à cette heure.");
        }

        boolean salleOccupee = consultationRepository.existsBySalleAndDateHeure(
                consultation.getSalle().getIdSalle(), consultation.getDate(), consultation.getHeure());
        if (salleOccupee) {
            throw new IllegalStateException("La salle est déjà réservée à cette heure.");
        }

       Consultation Existingconsultation = this.consultationRepository.read(id);

        if(consultation.getStatus() == null){
            consultation.setStatus(Existingconsultation.getStatus());
        }

        this.consultationRepository.update(consultation, id);
    }

    @Override
    public void delete(int id) {
        if(id == 0 || id < 1){
            throw new IllegalArgumentException("Le id est invalide.");
        }
        this.consultationRepository.delete(id);
    }

    @Override
    public void CancelConsultation(int id){
        Consultation consultation = this.consultationRepository.read(id);
        if(consultation == null){
            throw new IllegalArgumentException("La consultation avec l'ID " + id + " n'existe pas");
        }
        consultation.setStatus(Status.ANNULEE);
        this.consultationRepository.update(consultation, id);
    }

}

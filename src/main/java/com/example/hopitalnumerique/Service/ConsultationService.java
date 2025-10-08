package com.example.hopitalnumerique.Service;

import com.example.hopitalnumerique.Model.Consultation;
import com.example.hopitalnumerique.Repository.Interfaces.IConsultationRepository;
import com.example.hopitalnumerique.Service.Interfaces.IConsultationService;

import java.util.List;

public class ConsultationService implements IConsultationService {
    private IConsultationRepository consultationRepository;

    public ConsultationService(IConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void create(Consultation consultation) {
        this.consultationRepository.create(consultation);
    }

    @Override
    public Consultation read(int id) {
        return this.consultationRepository.read(id);
    }

    @Override
    public List<Consultation> readAll() {
        return this.consultationRepository.readAll();
    }

    @Override
    public void update(Consultation consultation, int id) {
        this.consultationRepository.update(consultation, id);
    }

    @Override
    public void delete(int id) {
        this.consultationRepository.delete(id);
    }
}

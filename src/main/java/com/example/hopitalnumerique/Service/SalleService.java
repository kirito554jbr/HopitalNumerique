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
    public void create(Salle salle) {
        this.salleRepository.create(salle);
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

package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface ISalleRepository {
    void create(Salle salle);
    Salle read(int id);
    List<Salle> readAll();
    void update(Salle salle, int id);
    void delete(int id);
    boolean existsByNomSalle(String nomSalle);
}

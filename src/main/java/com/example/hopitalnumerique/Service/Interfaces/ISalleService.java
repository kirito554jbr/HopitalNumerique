package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface ISalleService {
    void create(Salle salle) throws Exception;
    Salle read(int id);
    List<Salle> readAll();
    void update(Salle salle, int id);
    void delete(int id);
}

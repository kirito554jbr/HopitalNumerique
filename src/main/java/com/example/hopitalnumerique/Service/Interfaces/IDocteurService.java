package com.example.hopitalnumerique.Service.Interfaces;

import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Salle;

import java.util.List;

public interface IDocteurService {
    void create(Docteur docteur);
    Docteur read(int id);
    List<Docteur> readAll();
    void update(Docteur docteur, int id);
    void delete(int id);
}

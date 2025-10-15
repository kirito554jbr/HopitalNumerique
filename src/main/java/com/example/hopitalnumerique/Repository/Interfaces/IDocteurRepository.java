package com.example.hopitalnumerique.Repository.Interfaces;

import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Personne;

import java.util.List;

public interface IDocteurRepository {
    void create(Docteur docteur);
    Docteur read(int id);
    List<Docteur> readAll();
    void update(Docteur docteur, int id);
    void delete(int id);
    Docteur findByCredentials(Personne personne);
    Docteur findByName(String name);
    Docteur findByEmail(String email);
}

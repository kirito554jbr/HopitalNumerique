package com.example.hopitalnumerique.Repository;


import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Personne;
import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.IDocteurRepository;
import jakarta.persistence.*;

import java.util.List;

public class DocteurRepository implements IDocteurRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void create(Docteur docteur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(docteur);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Docteur read(int id) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = em.find(Docteur.class, id);
        em.close();
        return docteur;
    }

    @Override
    public List<Docteur> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Docteur> docteurs = em.createQuery("SELECT d FROM Docteur d", Docteur.class).getResultList();
        em.close();
        return docteurs;
    }

    @Override
    public void update(Docteur docteur, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Docteur docteur1 = em.find(Docteur.class, id);
        docteur1.setNom(docteur.getNom());
        docteur1.setPrenom(docteur.getPrenom());
        docteur1.setEmail(docteur.getEmail());
        docteur1.setPassword(docteur.getPassword());
        docteur1.setSpecialite(docteur.getSpecialite());
        docteur1.setDepartment(docteur.getDepartment());
        em.merge(docteur1);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = em.find(Docteur.class, id);
        em.getTransaction().begin();
        if (docteur != null) {
            em.remove(docteur);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Docteur findByCredentials(Personne personne) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = null;

        try {
            docteur = em.createQuery("""
            SELECT d FROM Docteur d 
            WHERE d.nom = :nom 
              AND d.prenom = :prenom 
              AND d.email = :email 
              AND d.password = :password
        """, Docteur.class)
                    .setParameter("nom", personne.getNom())
                    .setParameter("prenom", personne.getPrenom())
                    .setParameter("email", personne.getEmail())
                    .setParameter("password", personne.getPassword())
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Docteur not found or error: " + e.getMessage());
        } finally {
            em.close();
        }

        return docteur;
    }

    @Override
    public Docteur findByName(String name) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = null;
        try {
            docteur = em.createQuery(
                            "SELECT d FROM Docteur d WHERE d.nom = :name", Docteur.class)
                    .setParameter("name", name)
                    .getSingleResult();

        }catch (Exception e){
            System.out.println("Docteur not found or error: " + e.getMessage());
        }
        return docteur;
    }

    @Override
    public Docteur findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = null;
        try {
            docteur = em.createQuery(
                    "SELECT d FROM Docteur d WHERE d.email = :email", Docteur.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (Exception e){
            System.out.println("Docteur not found or error: " + e.getMessage());
        }
        return docteur;
    }

}

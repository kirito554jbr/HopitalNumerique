package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Salle;
import jakarta.persistence.*;

import java.util.List;

public class SalleRepository {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void create(Salle salle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
        em.close();
    }

    public Salle read(Long id) {
        EntityManager em = emf.createEntityManager();
        Salle salle = em.find(Salle.class, id);
        em.close();
        return salle;
    }

    public List<Salle> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Salle> salles = em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
        em.close();
        return salles;
    }

    public void update(Salle salle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(salle);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Salle salle = em.find(Salle.class, id);
        if (salle != null) {
            em.remove(salle);
        }
        em.getTransaction().commit();
        em.close();
    }
}

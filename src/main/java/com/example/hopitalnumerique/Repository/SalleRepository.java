package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import jakarta.persistence.*;

import java.util.List;

public class SalleRepository implements ISalleRepository {


    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void create(Salle salle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Salle read(int id) {
        EntityManager em = emf.createEntityManager();
        Salle salle = em.find(Salle.class, id);
        em.close();
        return salle;
    }

    @Override
    public List<Salle> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Salle> salles = em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
        em.close();
        return salles;
    }

    @Override
    public void update(Salle salle, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Salle salleGet = em.find(Salle.class,id);
        salleGet.setNomSalle(salle.getNomSalle());
        salleGet.setCapacite(salle.getCapacite());
        em.merge(salleGet);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Salle salle = em.find(Salle.class, id);
        if (salle != null) {
            em.remove(salle);
        }
        em.getTransaction().commit();
        em.close();
    }

    public boolean existsByNomSalle(String nomSalle) {

        Salle salle = null;
        EntityManager em = emf.createEntityManager();
            try {
                salle = em.createQuery(
                            "SELECT s FROM Salle s WHERE s.nomSalle = :name", Salle.class)
                    .setParameter("name", nomSalle)
                    .getSingleResult();
            }catch(NoResultException e){
                System.out.println("Le nom salle n'existe pas");
            }
        if (salle != null) {
            return true;
        }
        return false;
    }

    @Override
    public Salle readByNomSalle(String nomSalle) {
        EntityManager em = emf.createEntityManager();
        Salle salle = null;
        try {
            salle = em.createQuery(
                            "SELECT s FROM Salle s WHERE s.nomSalle = :name", Salle.class)
                    .setParameter("name", nomSalle)
                    .getSingleResult();
        }catch(NoResultException e){
            System.out.println("Le nom salle n'existe pas");
        }
        return salle;
    }
}

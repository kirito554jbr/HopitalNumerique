package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Consultation;
import com.example.hopitalnumerique.Repository.Interfaces.IConsultationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@ToString
public class ConsultationRepository implements IConsultationRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void create(Consultation consultation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(consultation);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Consultation read(int id) {
        EntityManager em = emf.createEntityManager();
        Consultation consultation = em.find(Consultation.class, id);
        em.close();
        return consultation;
    }

    @Override
    public List<Consultation> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Consultation> consultations = em.createQuery("SELECT c FROM Consultation c", Consultation.class).getResultList();
        em.close();
        return consultations;
    }

    @Override
    public void update(Consultation consultation, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Consultation consultation1 = em.find(Consultation.class, id);
        consultation1.setDate(consultation.getDate());
        consultation1.setHeure(consultation.getHeure());
        consultation1.setStatus(consultation.getStatus());
        consultation1.setCompteRendu(consultation.getCompteRendu());
        consultation1.setPatient(consultation.getPatient());
        consultation1.setDocteur(consultation.getDocteur());
        consultation1.setSalle(consultation.getSalle());
        em.merge(consultation);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        Consultation consultation = em.find(Consultation.class, id);
        em.getTransaction().begin();
        if (consultation != null) {
            em.remove(consultation);
        }
        em.getTransaction().commit();
        em.close();
    }



    @Override
    public boolean existsByDocteurAndDateHeure(int docteurId, LocalDate date, LocalDateTime heure) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT COUNT(c) FROM Consultation c " +
                "WHERE c.docteur.id = :docteurId " +
                "AND c.date = :date " +
                "AND c.heure = :heure";

        Long count = em.createQuery(jpql, Long.class)
                .setParameter("docteurId", docteurId)
                .setParameter("date", date)
                .setParameter("heure", heure)
                .getSingleResult();

        return count > 0;
    }

    @Override
    public boolean existsBySalleAndDateHeure(int salleId, LocalDate date, LocalDateTime heure) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT COUNT(c) FROM Consultation c " +
                "WHERE c.salle.id = :salleId " +
                "AND c.date = :date " +
                "AND c.heure = :heure";

        Long count = em.createQuery(jpql, Long.class)
                .setParameter("salleId", salleId)
                .setParameter("date", date)
                .setParameter("heure", heure)
                .getSingleResult();

        return count > 0;
    }
}

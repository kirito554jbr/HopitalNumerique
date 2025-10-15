package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Consultation;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PatientRepository implements com.example.hopitalnumerique.Repository.Interfaces.IPatientRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    private DocteurRepository docteurRepository = new DocteurRepository();

    @Override
    public void create(Patient patient) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Patient read(int id) {
        EntityManager em = emf.createEntityManager();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    @Override
    public List<Patient> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Patient> patients = em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
        em.close();
        return patients;
    }

    @Override
    public void update(Patient patient, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Patient patient1 = em.find(Patient.class, id);
        patient1.setNom(patient.getNom());
        patient1.setPrenom(patient.getPrenom());
        patient1.setEmail(patient.getEmail());
        patient1.setPassword(patient.getPassword());
        patient1.setPoids(patient.getPoids());
        patient1.setTaille(patient.getTaille());
        em.merge(patient1);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Patient readByNomPatient(String nom) {
        EntityManager em = emf.createEntityManager();
        Patient patient = null;
        try {
            patient = em.createQuery(
                            "SELECT p FROM Patient p WHERE p.nom = :name", Patient.class)
                    .setParameter("name", nom)
                    .getSingleResult();
        }catch (Exception e) {
            System.out.println("Erreur de connexion" + e.getMessage());
        }

        return patient;
    }

    @Override
    public Patient findByEmail(String email){
       EntityManager em = emf.createEntityManager();
         Patient patient = null;
        try {
            patient = em.createQuery(
                            "SELECT p FROM Patient p WHERE p.email = :email", Patient.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (Exception e) {
            System.out.println("Erreur de connexion" + e.getMessage());
        }
        return patient;
    }

    @Override
    public List<Patient> getByDocteur(String docteur) {

        EntityManager em = emf.createEntityManager();
        Docteur docteur1 = docteurRepository.findByName(docteur);
        List<Patient> patients = null;
        try {
            patients = em.createQuery(
                            "SELECT DISTINCT p FROM Consultation c " +
                                    "JOIN c.patient p " +
                                    "JOIN c.docteur d " +
                                    "WHERE d.id = :docteurId",
                            Patient.class)
                    .setParameter("docteurId", docteur1.getId())
                    .getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return patients;
    }
}

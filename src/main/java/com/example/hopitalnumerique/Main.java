package com.example.hopitalnumerique;

import com.example.hopitalnumerique.Repository.SalleRepository;
import com.example.hopitalnumerique.Model.Salle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

         EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        EntityManager em;
        Salle salle = new Salle("Aymen", 20);
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(salle);
            em.getTransaction().commit();
            em.close();
            emf.close();

        System.out.println("saved");



//        SalleRepository salle = new SalleRepository();
//
//        // Create
//        salle.create(new Salle("Aymen", 20));
//
//        // Read
//        Salle user = salle.read(1L);
//        System.out.println("Salle: " + user.getNomSalle() + " - " + user.getCapacite());
//
//        // Update
//        user.setCapacite(30);
//        salle.update(user);
//
//        // Delete
//        salle.delete(1L);


    }
}

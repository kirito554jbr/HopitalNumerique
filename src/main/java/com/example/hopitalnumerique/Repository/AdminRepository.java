package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Admin;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Repository.Interfaces.IAdminRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AdminRepository implements IAdminRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");


    @Override
    public void create(Admin admin) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Admin read(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin admin = em.find(Admin.class, id);
        em.getTransaction().commit();
        em.close();
        return admin;
    }

    @Override
    public List<Admin> readAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Admin> admins = em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
        em.close();
        return admins;
    }

    @Override
    public void update(Admin admin, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin updateAdmin = em.find(Admin.class, id);
        updateAdmin.setNom(admin.getNom());
        updateAdmin.setPrenom(admin.getPrenom());
        updateAdmin.setEmail(admin.getEmail());
        updateAdmin.setPassword(admin.getPassword());
        em.merge(updateAdmin);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       Admin deleteAdmin = em.find(Admin.class, id);
       if (deleteAdmin != null) {
       em.remove(deleteAdmin);
       }
       em.getTransaction().commit();
       em.close();
    }

    @Override
    public Admin findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Admin admin = null;
        try {
            admin = em.createQuery(
                            "SELECT d FROM Admin d WHERE d.email = :email", Admin.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (Exception e){
            System.out.println("Admin not found or error: " + e.getMessage());
        }
        return admin;
    }
}

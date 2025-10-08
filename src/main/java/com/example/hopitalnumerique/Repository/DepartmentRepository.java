package com.example.hopitalnumerique.Repository;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.IDepartmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import com.example.hopitalnumerique.Model.Department;

public class DepartmentRepository implements IDepartmentRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void create(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Department read(int id) {
        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, id);
        em.close();
        return department;
    }

    @Override
    public List<Department> readAll() {
        EntityManager em = emf.createEntityManager();
        List<Department> departments =  em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        em.close();
        return departments;
    }

    @Override
    public void update(Department department, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department1 = em.find(Department.class, id);
        department1.setNom(department.getNom());
        department1.setDocteurs(department.getDocteurs());
        em.merge(department1);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department = em.find(Department.class,id);
        if(department !=null){
            em.remove(department);
        }
            em.getTransaction().commit();
        em.close();
    }
}

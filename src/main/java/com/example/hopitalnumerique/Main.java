package com.example.hopitalnumerique;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Model.Personne;
import com.example.hopitalnumerique.Repository.DepartmentRepository;
import com.example.hopitalnumerique.Repository.DocteurRepository;
import com.example.hopitalnumerique.Repository.SalleRepository;
import com.example.hopitalnumerique.Model.Salle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SalleRepository salle = new SalleRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        DocteurRepository docteurRepository = new DocteurRepository();

        // Create
//        salle.create(new Salle("IbnRochd", 20));
////
//        departmentRepository.create(new Department("Surgery"));
//        Department department = new Department("Surgery");

//        Department department = departmentRepository.finByNom("Surgery");
//        Personne p = Personne.builder()
//                .nom("Fouzia")
//                .prenom("Erraji")
//                .email("Fouzia@gmail.com")
//                .password("0000")
//                .build();
//////
//        Docteur docteur = Docteur.builder()
//                .specialite("sergury")
//                .department(department)
//                .personne(p)
//                .build();
//

//        Docteur docteur = Docteur.builder()
//                .specialite("Surgery")
//                .department(department)
//                .personne(p)
//                .build();
////        p.setDocteur(docteur);
//
//        docteurRepository.create(docteur);


//        Department department = departmentRepository.finByNom("Surgery");
//
//        // Create Docteur directly - no separate Personne needed!
//        Docteur docteur = Docteur.builder()
//                .nom("Ahmed")
//                .prenom("rajib")
//                .email("ahmed@gmail.com")
//                .password("0000")
//                .specialite("Surgery")
//                .department(department)
//                .planing(new ArrayList<>())
//                .build();
//
//        docteurRepository.create(docteur);
       Docteur docteur = docteurRepository.read(1);
        System.out.println("Nom: " + docteur.getNom());
        System.out.println("Prenom: " + docteur.getPrenom());
        System.out.println("Email: " + docteur.getEmail());
        System.out.println("Specialite: " + docteur.getSpecialite());
        System.out.println("Department: " + docteur.getDepartment().getNom());
//        System.out.println(docteur);

//        System.out.println(docteurRepository.findByCredentials(new Personne("ayemn","jebrane", "aymen@gmail.com","0000")));


//        docteurRepository.create(new Docteur("aymen","jebrane","aymen@gmail.com", "0000","sergury", department,new ArrayList<>()));
//
//        // Read
//        Salle user = salle.read(2);
//        System.out.println("Salle: " + user.getNomSalle() + " - " + user.getCapacite());

//        // Update
//        salle.(30);
//        salle.update(new Salle("brekingCode", 20), 1);
//
//        // Delete
//        salle.delete(3);
//        System.out.println(salle.readAll());



    }
}

package com.example.hopitalnumerique;

import com.example.hopitalnumerique.Model.*;
import com.example.hopitalnumerique.Repository.*;
import com.example.hopitalnumerique.Repository.Interfaces.IAdminRepository;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SalleRepository salle = new SalleRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        DocteurRepository docteurRepository = new DocteurRepository();
        PatientRepository patientRepository = new PatientRepository();
        ConsultationRepository consultationRepository = new ConsultationRepository();
        ISalleRepository salleRepository = new SalleRepository();
        IAdminRepository adminRepository = new AdminRepository();

        // Create
//        salle.create(new Salle("IbnRochd", 20));
////
//        departmentRepository.create(new Department("Ophtalmologisme"));
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


//        Department department = departmentRepository.finByNom("Ophtalmologisme");
//
//        // Create Docteur directly - no separate Personne needed!
//        Docteur docteur = Docteur.builder()
//                .nom("Hamza")
//                .prenom("Sadiq")
//                .email("hamza@gmail.com")
//                .password("0000")
//                .specialite("Ophtalmologiste")
//                .department(department)
//                .planing(new ArrayList<>())
//                .build();
//
//        docteurRepository.create(docteur);
//       Docteur docteur = docteurRepository.read(1);
//        System.out.println("Nom: " + docteur.getNom());
//        System.out.println("Prenom: " + docteur.getPrenom());
//        System.out.println("Email: " + docteur.getEmail());
//        System.out.println("Specialite: " + docteur.getSpecialite());
//        System.out.println("Department: " + docteur.getDepartment().getNom());
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

//        ----------------------------------- Patient --------------------------------------
//        Patient patient = Patient.builder()
//                .nom("harit")
//                .prenom("ennair")
//                .email("harit@gmail.com")
//                .password("0000")
//                .poids(87l)
//                .taille(185l)
//                .consultations(new ArrayList<>())
//                .build();
//
////        patientRepository.create(patient);
//
//
//        patientRepository.update(patient,2);


//     -----------------------------------------   Consultation   ----------------------------------
//        Docteur docteur = docteurRepository.findByName("Ahmed");
//        Patient patient = patientRepository.readByNomPatient("Morad");
//        Salle salle1 = salleRepository.readByNomSalle("IbnRochd");
//
//        Consultation consultation = Consultation.builder()
//                .date(LocalDate.now())
//                .heure(LocalDate.now().atStartOfDay())
//                .status(Status.RESERVEE)
//                .compteRendu("K7al")
//                .patient(patient)
//                .docteur(docteur)
//                .salle(salle1)
//                .build();
//
//        consultationRepository.create(consultation);

//        List<Patient> patients = patientRepository.getByDocteur("Ahmed");
//
//        for (Patient patient : patients) {
//            System.out.println("Name : " + patient.getNom());
//            System.out.println("Prename : " + patient.getPrenom());
//            System.out.println("Poids : " + patient.getPoids());
//            System.out.println("Taille : " + patient.getTaille());
//        }

//        Admin admin = Admin.builder()
//                        .nom("abdo")
//                        .prenom("admin")
//                        .email("admin@gmail.com")
//                        .password("0000")
//                        .build();
//
//
//        adminRepository.create(admin);


    }
}

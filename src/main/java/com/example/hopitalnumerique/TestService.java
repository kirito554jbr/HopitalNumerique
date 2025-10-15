package com.example.hopitalnumerique;

import com.example.hopitalnumerique.Model.*;
import com.example.hopitalnumerique.Repository.ConsultationRepository;
import com.example.hopitalnumerique.Repository.DocteurRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IConsultationRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IDocteurRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IPatientRepository;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Repository.PatientRepository;
import com.example.hopitalnumerique.Repository.SalleRepository;
import com.example.hopitalnumerique.Service.ConsultationService;
import com.example.hopitalnumerique.Service.Interfaces.IConsultationService;
import com.example.hopitalnumerique.Service.Interfaces.IDocteurService;
import com.example.hopitalnumerique.Service.Interfaces.IPatientService;
import com.example.hopitalnumerique.Service.PatientService;
import com.example.hopitalnumerique.Service.SalleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestService {

    public static void main(String[] args) {
        ISalleRepository salleRepository = new SalleRepository();
        SalleService salleService = new SalleService(salleRepository);
        IConsultationRepository consultationRepository = new ConsultationRepository();
        IConsultationService consultationService = new ConsultationService(consultationRepository);
        IPatientRepository patientRepository = new PatientRepository();
        IDocteurRepository docteurRepository = new DocteurRepository();

//        try{
////        salleService.create(new Salle("test2", 130));
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    List<Consultation> Consultation1 = new ArrayList<>();
//    Patient patient = patientRepository.read(2);
//        Docteur docteur = docteurRepository.read(1);
//    Salle salle = salleRepository.read(1);
//    Docteur docteur = ;
//
//    Consultation consultation = Consultation.builder()
//            .date(LocalDate.of(2025, 10, 9))
//            .heure(LocalDateTime.of(LocalDate.of(2025, 10, 9), LocalTime.of(00, 10, 00)))
//            .status(Status.RESERVEE)
//            .compteRendu("rtrewwddfre")
//            .patient(patient)
//            .docteur(docteur)
//            .salle(salle)
//            .build();
//
//
//    consultationService.create(consultation);
        IPatientService patientService = new PatientService(patientRepository);
        Patient patient = Patient.builder()
                .nom("harit")
                .prenom("ennair")
                .email("harit@gmail.com")
                .password("0000")
                .poids(90l)
                .taille(185l)
                .consultations(new ArrayList<>())
                .build();
        patientService.update(patient,2);

    }

}

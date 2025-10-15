package com.example.hopitalnumerique.Controller;

import com.example.hopitalnumerique.Model.Patient;
import com.example.hopitalnumerique.Repository.Interfaces.IPatientRepository;
import com.example.hopitalnumerique.Repository.PatientRepository;
import com.example.hopitalnumerique.Service.Interfaces.IPatientService;
import com.example.hopitalnumerique.Service.PatientService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {
    private IPatientRepository patientRepository;
    private IPatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        patientRepository = new PatientRepository();
       patientService = new PatientService(patientRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
             List<Patient> patients = patientService.readAll();
             req.setAttribute("patients", patients);
            req.getRequestDispatcher("/WEB-INF/pages/patient.jsp").forward(req, resp);
        } else if (action.equals("read")) {
             Patient patient = patientService.read(Integer.parseInt(req.getParameter("id")));
             req.setAttribute("patient", patient);
            req.getRequestDispatcher("/WEB-INF/pages/patient.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if("create".equals(req.getParameter("action"))){
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            float poids = Float.parseFloat(req.getParameter("poids"));
            float taille = Float.parseFloat(req.getParameter("taille"));
            Patient patient = new Patient(nom, prenom, email, password, poids, taille);
            try {
                patientService.create(patient);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        resp.sendRedirect("patient");
        } else if ("update".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            float poids = Float.parseFloat(req.getParameter("poids"));
            float taille = Float.parseFloat(req.getParameter("taille"));
            Patient patient = new Patient(nom, prenom, email, password, poids, taille);
            try {
                patientService.update(patient, id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("patient");
        } else if ("delete".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                patientService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("patient");
        }
    }
}

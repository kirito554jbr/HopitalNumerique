package com.example.hopitalnumerique.Controller;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Model.Docteur;
import com.example.hopitalnumerique.Repository.DepartmentRepository;
import com.example.hopitalnumerique.Repository.DocteurRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IDepartmentRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IDocteurRepository;
import com.example.hopitalnumerique.Service.DepartmentService;
import com.example.hopitalnumerique.Service.DocteurService;
import com.example.hopitalnumerique.Service.Interfaces.IDepartmentService;
import com.example.hopitalnumerique.Service.Interfaces.IDocteurService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "docteur", value = "/docteur")
public class DocteurServlet extends HttpServlet {
    private IDocteurRepository docteurRepository;
    private IDocteurService docteurService;
    private IDepartmentRepository departmentRepository;
    private IDepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        docteurRepository = new DocteurRepository();
        docteurService = new DocteurService(docteurRepository);
        departmentRepository = new DepartmentRepository();
        departmentService = new DepartmentService(departmentRepository);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            List<Docteur> docteurs = docteurService.readAll();
            req.setAttribute("docteurs", docteurs);
            req.getRequestDispatcher("/WEB-INF/pages/docteur.jsp").forward(req, resp);
        } else if (action.equals("read")) {
            Docteur docteur = docteurService.read(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("docteur", docteur);
            req.getRequestDispatcher("/WEB-INF/pages/docteur.jsp").forward(req, resp);
        }
    }

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        if("create".equals(req.getParameter("action"))){
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String departement = req.getParameter("departement");
            String specialite = req.getParameter("specialite");

            Department department = departmentService.finByNom(departement);

            Docteur docteur = new Docteur(nom, prenom, email, password, department, specialite);
            try {
                docteurService.create(docteur);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("docteur");

        } else if ("update".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String departement = req.getParameter("departement");
            String specialite = req.getParameter("specialite");

            Department department = departmentService.finByNom(departement);

            Docteur docteur = new Docteur(nom, prenom, email, password, department, specialite);
            try {
                docteurService.update(docteur, id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("docteur");
        } else if ("delete".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                docteurService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("docteur");

        }
    }
}

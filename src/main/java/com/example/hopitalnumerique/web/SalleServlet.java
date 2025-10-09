package com.example.hopitalnumerique.web;

import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Repository.SalleRepository;
import com.example.hopitalnumerique.Service.Interfaces.ISalleService;
import com.example.hopitalnumerique.Service.SalleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/salle")
public class SalleServlet extends HttpServlet {
    private ISalleRepository  salleRepository =  new SalleRepository();
    private ISalleService salleService = new SalleService(salleRepository);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("").forward(req,resp);

        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<Salle> salles = salleService.readAll();
            req.setAttribute("salles", salles);
            req.getRequestDispatcher("/salleList.jsp").forward(req, resp);
        } else if (action.equals("read")) {
            Salle salle = salleService.read(Integer.parseInt(req.getParameter("id")));
        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");



        // 🧩 CREATE
        if ("create".equals(action)) {
            String nomSalle = req.getParameter("nomSalle");
            int capacite = Integer.parseInt(req.getParameter("capacite"));
            Salle salle = new Salle(nomSalle, capacite);
//            salleService.create(salle);
//            resp.sendRedirect("/WEB-INF/salles.jsp");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        // 🧩 UPDATE
        else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("idSalle"));
            String nomSalle = req.getParameter("nomSalle");
            int capacite = Integer.parseInt(req.getParameter("capacite"));
            Salle salle = new Salle(nomSalle, capacite);
            salleService.update(salle, id);
            resp.sendRedirect("salle?action=list");
        }else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("idSalle"));
            salleService.delete(id);
        }
    }
}


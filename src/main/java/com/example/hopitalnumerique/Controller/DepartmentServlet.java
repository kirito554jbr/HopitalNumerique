package com.example.hopitalnumerique.Controller;

import com.example.hopitalnumerique.Model.Department;
import com.example.hopitalnumerique.Repository.DepartmentRepository;
import com.example.hopitalnumerique.Repository.Interfaces.IDepartmentRepository;
import com.example.hopitalnumerique.Service.DepartmentService;
import com.example.hopitalnumerique.Service.Interfaces.IDepartmentService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "department", value = "/department")
public class DepartmentServlet extends HttpServlet {
    private IDepartmentRepository departmentRepository;
    private IDepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        departmentRepository = new DepartmentRepository();
        departmentService = new DepartmentService(departmentRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String action = req.getParameter("action");
        if (action == null || action.equals("list")) {
            List<Department> departments = departmentService.readAll();
            req.setAttribute("departments", departments);
            req.getRequestDispatcher("/WEB-INF/pages/department.jsp").forward(req, resp);
        } else if (action.equals("read")) {
            Department department = departmentService.read(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("department", department);
            req.getRequestDispatcher("/WEB-INF/pages/department.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        if("create".equals(req.getParameter("action"))){
            String nom = req.getParameter("nom");
            Department department = new Department(nom);
            try {
                departmentService.create(department);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("department");
        } else if ("update".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            Department department = new Department(nom);
            try {
                departmentService.update(department, id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("department");
        } else if ("delete".equals(req.getParameter("action"))) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                departmentService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("department");
        }
    }
}

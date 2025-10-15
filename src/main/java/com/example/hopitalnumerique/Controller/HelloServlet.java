package com.example.hopitalnumerique.Controller;

import java.io.*;
import java.util.List;

import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Repository.SalleRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private ISalleRepository salle;

    public void init() {
        message = "Hello java!";
        salle = new SalleRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        List<Salle> salles = salle.readAll();

//        request.setAttribute("action", "list");
//        request.getRequestDispatcher("/salle").forward(request,response);
//        request.setCharacterEncoding("utf-8");
//        String name = request.getParameter("name");

//        response.setContentType("text/plain");
        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write("<h1>Hello " + name + "!</h1>");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
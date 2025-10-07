package com.example.hopitalnumerique;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello java!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
package com.groupeonepoint.enseirb.war.hello;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name="UsersServlet", urlPatterns="/users")
public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        UserDatabase db = UserDatabaseFactory.getInstance();
        // On génère la réponse
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        out.println("  <tr>");
        out.println("    <style>Firstname</style>");
        out.println("    <style>Lastname</style>");        
        out.println("  </tr>");
        for(User entry : db) {
            out.println("<tr>");
            out.println("<td>"+entry.getPrenom()+"</td>");
            out.println("<td>"+entry.getNom()+"</td>");          
        }
        out.println("</table>");        
        out.println("<form action='/wildfly-project/adduser.view'>");
        	out.println("<input type='submit' value='new user'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
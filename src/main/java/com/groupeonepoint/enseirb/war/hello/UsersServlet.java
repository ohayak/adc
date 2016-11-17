package com.groupeonepoint.enseirb.war.hello;


import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name="UsersServlet", urlPatterns="/users")
public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject private UserDatabase db;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        db = UserDatabaseFactory.getInstance();
        req.setAttribute( "usersDatabase", db );
        this.getServletContext().getRequestDispatcher( "/ListUsers.jsp" ).forward( req, resp );
    }

}
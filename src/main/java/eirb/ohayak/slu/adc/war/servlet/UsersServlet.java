package eirb.ohayak.slu.adc.war.servlet;


import eirb.ohayak.slu.adc.war.bean.UserDatabase;
import eirb.ohayak.slu.adc.war.bean.UserDatabaseFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name="UsersServlet", urlPatterns="/admin/users")
public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDatabase db = UserDatabaseFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute( "usersDatabase", db );
        req.getRequestDispatcher( "/ListUsers.jsp" ).forward( req, resp );
    }

}
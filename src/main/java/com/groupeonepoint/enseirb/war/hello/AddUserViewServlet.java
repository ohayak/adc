package com.groupeonepoint.enseirb.war.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mrhyk on 08/11/2016.
 */

@WebServlet(name="AddUserView", urlPatterns = "/adduser.view")
public class AddUserViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // On génère la réponse
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        this.getServletContext().getRequestDispatcher( "/ListUsers.jsp" ).forward( req, resp );
    }

}
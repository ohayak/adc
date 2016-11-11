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
        out.write("<!DOCTYPE html>");
        out.write("<html>");
        out.write("<body>");
        out.write("<form action='/wildfly-project/adduser.action' method='post'>");
        out.write("First name:<br>");
        out.write("<input type='text' name='firstname' />");
        out.write("<br>");
        out.write("Last name:<br>");
        out.write("<input type='text' name='lastname' />");
        out.write("<br><br>");
        out.write("<input type='submit' value='Submit' />");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");
        out.flush();
    }

}
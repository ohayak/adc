package eirb.ohayak.server;

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

@WebServlet(name="NewUserServlet", urlPatterns = "/newuser")
public class NewUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // On génère la réponse
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html>");
        out.write("<html>");
        out.write("<body>");
        out.write("<form action=\"adduser\">");
        out.write("First name:<br>");
        out.write("<input type=\"text\" name=\"firstname\" value=\"Mickey\">");
        out.write("<br>");
        out.write("Last name:<br>");
        out.write("<input type=\"text\" name=\"lastname\" value=\"Mouse\">");
        out.write("<br><br>");
        out.write("<input type=\"submit\" value=\"Submit\">");
        out.write("</form>");
        out.write("<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"action_page.php\".</p>");
        out.write("</html>");
        out.write("</body>");
    }

}

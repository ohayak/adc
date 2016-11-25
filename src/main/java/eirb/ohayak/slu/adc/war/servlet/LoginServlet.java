package eirb.ohayak.slu.adc.war.servlet;

import eirb.ohayak.slu.adc.war.bean.AuthenficationControler;
import eirb.ohayak.slu.adc.war.bean.AuthentificationControlerImpl;
import eirb.ohayak.slu.adc.war.bean.UserDatabase;
import eirb.ohayak.slu.adc.war.bean.UserDatabaseFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mrhyk on 21/11/2016.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDatabase db = UserDatabaseFactory.getInstance();
    private AuthenficationControler controler = new AuthentificationControlerImpl(db);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher( "/Login.jsp" ).forward( req, res );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if (controler.checkIdentifiers(account,password)) {
            HttpSession session = req.getSession();
            session.setAttribute("connected", true);
            session.setAttribute("user", db.getByLogin(account));
            req.getRequestDispatcher("/Home.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher( "/Login.jsp" ).forward( req, res );
        }

    }
}

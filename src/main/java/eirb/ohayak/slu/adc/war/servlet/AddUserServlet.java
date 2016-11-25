package eirb.ohayak.slu.adc.war.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrhyk on 08/11/2016.
 */

@WebServlet(urlPatterns = "/admin/adduser")
public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher( "/AddUser.jsp" ).forward( req, resp );
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// On récupère un paramètre depuis la requète
//		UserDatabase db = UserDatabaseFactory.getInstance();
// 		String firstname = req.getParameter("firstname");
//		String lastname = req.getParameter("lastname");
//		String login = req.getParameter("login");
//		String password = req.getParameter("password");
//
//		if(firstname!=null && lastname!=null){
//			db.addUser(new User(firstname,lastname, login, password));
//			req.getRequestDispatcher( "/admin/users" ).forward( req, resp );
//		}
//	}
}
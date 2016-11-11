package com.groupeonepoint.enseirb.war.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrhyk on 08/11/2016.
 */

@WebServlet(name="AddUserAction", urlPatterns = "/adduser.action")
public class AddUserActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// On récupère un paramètre depuis la requète
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");

		if(firstname!=null&&lastname!=null){
			UserDatabase db = UserDatabaseFactory.getInstance();
			db.addUser(new User(firstname,lastname));
			resp.sendRedirect("/wildfly-project/users");
		}
		
        
       
	}

}
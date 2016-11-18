package com.groupeonepoint.enseirb.war.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MeteoView", urlPatterns="/forward/meteo.view")
public class MeteoViewServlet extends HttpServlet {

	 private static final long serialVersionUID = 1L;

	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        
	        this.getServletContext().getRequestDispatcher("/Meteo.jsp").forward(req,resp);
	    }
}

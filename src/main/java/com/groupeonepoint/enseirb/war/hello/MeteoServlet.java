package com.groupeonepoint.enseirb.war.hello;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrhyk on 14/11/2016.
 */

@WebServlet(name = "MeteoAction", urlPatterns = "/meteo")
public class MeteoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private MeteoProvider meteoProvider;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/Meteo.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        if (city != null && !city.isEmpty()) {
            float temperature = meteoProvider.getCityTemperature("city");
            request.setAttribute("city", city);
            request.setAttribute("temperature", temperature);
        }
        request.getRequestDispatcher("/Meteo.jsp").forward(request, response);
    }
}

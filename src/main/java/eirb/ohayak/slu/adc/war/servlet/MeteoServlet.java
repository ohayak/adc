package eirb.ohayak.slu.adc.war.servlet;

import eirb.ohayak.slu.adc.war.bean.MeteoProvider;
import eirb.ohayak.slu.adc.war.bean.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

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
        String user = ((User) request.getSession().getAttribute("user")).getLogin();
        HashMap<String, Integer> visits =(HashMap<String, Integer>) getServletContext().getAttribute("visitRecorder");
        if (visits == null) {
            visits = new HashMap<String, Integer>();
        }
        Integer i;
        if ((i=visits.get(user)) != null) {
            visits.put(user,i+1);
        } else {
            visits.put(user, 0);
        }
        getServletContext().setAttribute("visitRecorder",visits);
        request.getRequestDispatcher("/Meteo.jsp").forward(request, response);
    }
}

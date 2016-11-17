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
@WebServlet(name = "MeteoAction", urlPatterns = "cdi/meteo.action")
public class MeteoActionServlet extends HttpServlet {
    @Inject
    private MeteoProvider meteoProvider;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

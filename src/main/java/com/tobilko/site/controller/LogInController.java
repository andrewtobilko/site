package com.tobilko.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LogInController",
        urlPatterns = "/login",
        description = "processing of login requests"
)
public class LogInController extends HttpServlet {

    final static Logger logger = LoggerFactory.getLogger(LogInController.class);

    private final String PARAMETER_EMAIL = "email";
    private final String PARAMETER_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: request.getAttribute("factory");
        logger.debug("The request has been received - doGet");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doPost");
        String email = request.getParameter(PARAMETER_EMAIL);
        String password = request.getParameter(PARAMETER_PASSWORD);
        logger.debug("Email: {}, password: {}", email, password);

        logger.debug("type: ", request.getParameter("type"));

        if (request.getParameter("type") != null) {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("true");
        } else {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("false");
        }
        // TODO: init database connection
    }
}
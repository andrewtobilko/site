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
        name = "SignUpController",
        urlPatterns = "/signup",
        description = "processing of registration new users"
)
public class SignUpController extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private final String PARAMETER_NAME = "name";
    private final String PARAMETER_EMAIL = "email";
    private final String PARAMETER_PASSWORD = "password";
    private final String PARAMETER_CONFIRMED_PASSWORD = "confirmedpassword";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doGet");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doPost");

        String name = request.getParameter(PARAMETER_NAME);
        String email = request.getParameter(PARAMETER_EMAIL);
        String password = request.getParameter(PARAMETER_PASSWORD);
    }
}
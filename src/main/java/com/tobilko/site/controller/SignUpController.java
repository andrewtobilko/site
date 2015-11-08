package com.tobilko.site.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SignUpController",
        urlPatterns = "/signup",
        description = "processing of registration requests"
)
public class SignUpController extends HttpServlet {

    private final String PARAMETER_NAME = "name";
    private final String PARAMETER_EMAIL = "id";
    private final String PARAMETER_PASSWORD = "password";
    private final String PARAMETER_CONFIRMED_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
    }
}
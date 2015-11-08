package com.tobilko.site.controller;

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

    private final String PARAMETER_EMAIL = "id";
    private final String PARAMETER_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
}
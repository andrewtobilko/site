package com.tobilko.site.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SignUpController",
        urlPatterns = "/signup",
        description = "processing of registration new users",
        initParams = {
                @WebInitParam(name = "parameter.name", value ="name"),
                @WebInitParam(name = "parameter.email", value ="email"),
                @WebInitParam(name = "parameter.password", value ="password")
        }
)
public class SignUpController extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doGet");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doPost");

        String name = request.getParameter(getServletConfig().getInitParameter("parameter.name"));
        String email = request.getParameter(getServletConfig().getInitParameter("parameter.email"));
        String password = request.getParameter(getServletConfig().getInitParameter("parameter.password"));
    }
}
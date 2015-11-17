/*
 * Copyright (c) 2015. All rights reserved.
 */
package com.tobilko.site.controller;

import com.tobilko.site.service.CommandFactory;
import com.tobilko.site.service.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * {@code LogInController} is used to serve user requests for login.
 *
 * @author Andrew Tobilko
 */
@WebServlet(
        name = "LogInController",
        urlPatterns = "/login",
        description = "processing of user's login"
)
public class LogInController extends HttpServlet {
    /**
     * Used to choose a type of command in {@code CommandFactory}.
     */
    private static final String PARAMETER_COMMAND = "login";
    /**
     * Used to write to the logging system.
     */
    private final static Logger logger = LoggerFactory.getLogger(LogInController.class);

    /**
     * The {@code doGet} method is used to dispatch to the login page.
     *
     * @param request  the object of {@code HttpServletRequest} class that has been formed by Tomcat
     * @param response the object of {@code HttpServletResponse} class that has been formed by Tomcat
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received [doGet]");
        getServletContext().getRequestDispatcher(Page.LOGIN.getPath()).forward(request, response);
    }

    /**
     * The {@code doPost} method is used to authorize a user inside the system.
     *
     * @param request  the object of {@code HttpServletRequest} class that has been formed by Tomcat
     * @param response the object of {@code HttpServletResponse} class that has been formed by Tomcat
     * @throws ServletException
     * @throws IOException
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received [doPost]");
        authorize(request, response);
    }

    private void authorize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(new CommandFactory().defineCommand(PARAMETER_COMMAND).execute(request) ? "/" : "/login")
                .forward(request, response);
    }
}
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

@WebServlet(
        name = "SignUpController",
        urlPatterns = "/signup",
        description = "processing of registration new users"
)
public class SignUpController extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(SignUpController.class);
    /**
     * Used to choose a type of command in {@code CommandFactory}.
     */
    private static final String PARAMETER_COMMAND = "signup";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doGet");
        getServletContext().getRequestDispatcher(Page.SIGNUP.getPath()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doPost");
        register(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(new CommandFactory().defineCommand(PARAMETER_COMMAND).execute(request) ? Page.LOGIN.getPath() : Page.SIGNUP.getPath()).forward(request, response);
    }
}
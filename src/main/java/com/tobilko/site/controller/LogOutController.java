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
        name = "LogOutController",
        urlPatterns = "/logout",
        description = "processing of user's logout"
)
public class LogOutController extends HttpServlet {

    private static final String PARAMETER_COMMAND = "logout";

    private final static Logger logger = LoggerFactory.getLogger(LogOutController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received [doGet]");
        getServletContext().getRequestDispatcher(Page.LOGOUT.getPath()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received [doPost]");
        logOut(request, response);
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new CommandFactory().defineCommand(PARAMETER_COMMAND).execute(request);
        getServletContext().getRequestDispatcher(Page.INDEX.getPath()).forward(request, response);
    }
}

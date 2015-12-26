/*
 * Copyright (c) 2015. All rights reserved.
 */
package com.github.tobilko.controller;

import com.github.tobilko.service.Command;
import com.github.tobilko.service.command.CommandFactory;
import com.github.tobilko.service.Page;
import com.github.tobilko.service.command.AbstractCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request [{}] has been received.", request.getMethod());
        getServletContext().getRequestDispatcher(Page.SIGNUP.getPath()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request [{}] has been received.", request.getMethod());
        register(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory factory = (CommandFactory) request.getServletContext().getAttribute("factory");
        AbstractCommand command = factory.defineCommand(Command.SIGNUP.getName());
        String page = (command.execute(request) ? Page.LOGIN : Page.SIGNUP).getPath();
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

}
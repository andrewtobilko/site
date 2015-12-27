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

import static com.github.tobilko.service.Attribute.FACTORY_COMMAND;

@WebServlet("/logout")
public class LogOutController extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(LogOutController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request [{}] has been received.", request.getMethod());
        getServletContext().getRequestDispatcher(Page.LOGOUT.getPath()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request [{}] has been received.", request.getMethod());
        logOut(request, response);
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory factory = (CommandFactory) request.getServletContext().getAttribute(FACTORY_COMMAND.getName());
        AbstractCommand command = factory.defineCommand(Command.LOGOUT.getName());
        getServletContext().getRequestDispatcher(Page.INDEX.getPath()).forward(request, response);
    }

}

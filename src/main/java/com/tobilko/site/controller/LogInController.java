package com.tobilko.site.controller;

import com.tobilko.site.dao.DAO;
import com.tobilko.site.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LogInController",
        urlPatterns = "/login",
        description = "processing of user login",
        initParams = {
                @WebInitParam(name = "parameter.email", value = "email"),
                @WebInitParam(name = "parameter.password", value = "password")
        }
)
public class LogInController extends HttpServlet {

    final static Logger logger = LoggerFactory.getLogger(LogInController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doGet");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("The request has been received - doPost");

        String email = request.getParameter(getServletConfig().getInitParameter("parameter.email"));
        String password = request.getParameter(getServletConfig().getInitParameter("parameter.password"));

        DAO<User> dao = new DAO((EntityManager) getServletContext().getAttribute("manager"), User.class);

    }
}
package com.tobilko.site.controller;

import com.tobilko.site.dao.DAO;
import com.tobilko.site.entity.User;
import com.tobilko.site.service.Page;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "UsersController",
        urlPatterns = "/users",
        description = "shows all users"
)
public class UsersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", new DAO<>((EntityManager) request.getServletContext().getAttribute("manager"), User.class).findAll());
        getServletContext().getRequestDispatcher(Page.USERS.getPath()).forward(request, response);
    }
}

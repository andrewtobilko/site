package com.github.tobilko.listener;

import com.github.tobilko.service.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitializationListener implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(ServletContextInitializationListener.class);

    private EntityManagerFactory factory;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("The context has been initialized!");

        factory = Persistence.createEntityManagerFactory("site");
        servletContextEvent.getServletContext().setAttribute("manager", factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("factory", new CommandFactory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("The context has been destroyed!");
        factory.close();
    }
}
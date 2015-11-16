package com.tobilko.site.listener;

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
        logger.debug("The context has been initialized.");

        factory = Persistence.createEntityManagerFactory("site");
        servletContextEvent.getServletContext().setAttribute("manager", factory.createEntityManager());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("The context has been destroyed.");
        factory.close();
    }
}
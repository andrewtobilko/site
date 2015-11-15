package com.tobilko.site.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitializationListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(ServletContextInitializationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("The context has been initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("The context has been destroyed.");
    }
}
package com.tobilko.site.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SignUpCommand.class);

    /**
     * The constants that describe request parameters.
     */
    private static final String PARAMETER_NAME = "name";
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PASSWORD = "password";

    @Override
    public boolean execute(HttpServletRequest request) {
        return false;
    }
}

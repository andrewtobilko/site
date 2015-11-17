package com.tobilko.site.service.command;

import com.tobilko.site.dao.DAO;
import com.tobilko.site.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        DAO<User> dao = new DAO<>((EntityManager) request.getServletContext().getAttribute("manager"), User.class);

        String name = request.getParameter(PARAMETER_NAME);
        String email = request.getParameter(PARAMETER_EMAIL);
        String password = request.getParameter(PARAMETER_PASSWORD);

        List<User> list = dao.findAll();
        for (User user : list) {
            if (user.getEmail().equals(email)) {
                logger.debug("User with such email [{}] already exists!", email);
                return false;
            }
        }
        dao.add(new User(name, email, password));
        logger.debug("User [{}, {}] has been created!", name, email);
        return true;
    }
}

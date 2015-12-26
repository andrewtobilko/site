package com.github.tobilko.service.command;

import com.github.tobilko.dao.DAO;
import com.github.tobilko.dao.factory.DAOFactory;
import com.github.tobilko.dao.factory.UserDAOFactory;
import com.github.tobilko.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class SignUpCommand extends AbstractCommand {

    private static final Logger logger = LoggerFactory.getLogger(SignUpCommand.class);

    private static final String PARAMETER_NAME = "name";
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PASSWORD = "password";

    @Override
    public boolean execute(HttpServletRequest request) {
        DAOFactory<User> factory = new UserDAOFactory();
        DAO<User> dao = factory.createDAO((EntityManager) request.getServletContext().getAttribute("manager"));

        String name = request.getParameter(PARAMETER_NAME);
        String email = request.getParameter(PARAMETER_EMAIL);
        String password = request.getParameter(PARAMETER_PASSWORD);

        Collection<User> list = dao.getAll();

        for (User user : list) {
            if (user.getEmail().equals(email)) {
                logger.debug("The user with such email address [{}] has already existed!", email);
                return false;
            }
        }

        dao.add(new User(name, email, password));
        logger.debug("The user [{}, {}] has been created!", name, email);

        return true;
    }

}

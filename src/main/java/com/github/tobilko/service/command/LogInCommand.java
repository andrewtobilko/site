package com.github.tobilko.service.command;

import com.github.tobilko.dao.DAO;
import com.github.tobilko.dao.factory.DAOFactory;
import com.github.tobilko.dao.factory.UserDAOFactory;
import com.github.tobilko.entity.User;
import com.github.tobilko.service.Attribute;
import com.github.tobilko.service.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

public class LogInCommand extends AbstractCommand {

    private static final Logger logger = LoggerFactory.getLogger(LogInCommand.class);

    @Override
    public boolean execute(HttpServletRequest request) {
        DAOFactory<User> factory = new UserDAOFactory();
        DAO<User> dao = factory.createDAO((EntityManager) request.getServletContext()
                .getAttribute(Attribute.FACTORY_MANAGER.getName()));

        String email = request.getParameter(Parameter.EMAIL.getName());
        String password = request.getParameter(Parameter.PASSWORD.getName());
        String cause;

        Collection<User> list = dao.getAll();

        for (User user : list) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    logger.debug("The user [{}] has been authorized successfully!", email);
                    HttpSession session = request.getSession();
                    session.setAttribute(Attribute.USER.getName(), user);
                    return true;
                } else {
                    cause = "incorrect password";
                    logger.debug("The user authorization has been failed! [" + cause + "]");
                    request.setAttribute(Attribute.MESSAGE_PASSWORD.getName(), cause);
                    return false;
                }
            }
        }

        cause = "incorrect email";
        logger.debug("The user's authorization has been failed! [" + cause + "]");
        request.setAttribute(Attribute.MESSAGE_EMAIL.getName(), cause);

        return false;
    }
}

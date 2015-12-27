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
import java.util.Collection;

public class SignUpCommand extends AbstractCommand {

    private static final Logger logger = LoggerFactory.getLogger(SignUpCommand.class);

    @Override
    public boolean execute(HttpServletRequest request) {
        DAOFactory<User> factory = new UserDAOFactory();
        DAO<User> dao = factory.createDAO((EntityManager) request.getServletContext()
                .getAttribute(Attribute.FACTORY_MANAGER.getName()));

        String name = request.getParameter(Parameter.NAME.getName());
        String email = request.getParameter(Parameter.EMAIL.getName());
        String password = request.getParameter(Parameter.PASSWORD.getName());

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

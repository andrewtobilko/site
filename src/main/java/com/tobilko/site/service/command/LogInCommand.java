package com.tobilko.site.service.command;

import com.tobilko.site.dao.DAO;
import com.tobilko.site.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LogInCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LogInCommand.class);

    /**
     * The constants that describe request parameters.
     */
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PASSWORD = "password";

    @Override
    public boolean execute(HttpServletRequest request) {
        DAO<User> dao = new DAO<>((EntityManager) request.getServletContext().getAttribute("manager"), User.class);

        String email = request.getParameter(PARAMETER_EMAIL);
        String password = request.getParameter(PARAMETER_PASSWORD);

        List<User> list = dao.findAll();
        for (User user : list) {
            if (user.getEmail().equals(email)) {
                if(user.getPassword().equals(password)) {
                    logger.debug("The user [{}] has been authorized successfully!", user.getEmail());
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    return true;
                } else {
                    logger.debug("The user's authorization has been failed! Cause: incorrect password.");
                    request.setAttribute("message.password", "incorrect password");
                    return false;
                }
            }
        }
        logger.debug("The user's authorization has been failed! Cause: incorrect email.");
        request.setAttribute("message.email", "incorrect email");
        return false;
    }
}

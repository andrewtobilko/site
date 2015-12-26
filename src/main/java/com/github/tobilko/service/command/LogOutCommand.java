package com.github.tobilko.service.command;

import com.github.tobilko.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand extends AbstractCommand {

    private static final Logger logger = LoggerFactory.getLogger(LogOutCommand.class);

    @Override
    public boolean execute(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            logger.debug("The session [{}, {}] has been destroyed!", user.getDisplayName(), user.getEmail());
            request.getSession().invalidate();
            return true;
        }
        logger.debug("The session has not been destroyed!");
        return false;
    }

}

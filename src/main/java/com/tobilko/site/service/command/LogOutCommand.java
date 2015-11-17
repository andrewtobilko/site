package com.tobilko.site.service.command;

import com.tobilko.site.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LogOutCommand.class);

    @Override
    public boolean execute(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            logger.debug("The session for user [{}, {}] has been destroyed!", user.getDisplayName(), user.getEmail());
            request.getSession().invalidate();
            return true;
        }
        logger.debug("The session hasn't been destroyed!");
        return false;
    }
}

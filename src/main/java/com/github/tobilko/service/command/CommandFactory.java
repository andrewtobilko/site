package com.github.tobilko.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    private final static Logger logger = LoggerFactory.getLogger(CommandFactory.class);
    private List<Action> commands = new ArrayList<>();

    public AbstractCommand defineCommand(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException();
        }
        AbstractCommand command = null;
        try {
            Action action = Action.valueOf(type.toUpperCase());
            command = action.getCurrentCommand();
            commands.add(action);
            logger.debug("The previous commands [{}]", commands);
        } catch (IllegalArgumentException e) {
            logger.debug("The command [{}] has not been found!", type);
        }
        return command;
    }

}

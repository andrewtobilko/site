package com.github.tobilko.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    private final static Logger logger = LoggerFactory.getLogger(CommandFactory.class);
    private List<AbstractCommand> commands = new ArrayList<>();

    public AbstractCommand defineCommand(String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException();
        }
        AbstractCommand action = null;
        try {
            action = Action.valueOf(command.toUpperCase()).getCurrentCommand();
            commands.add(action);
        } catch (IllegalArgumentException e) {
            logger.debug("The command [{}] has not been found!", command);
        }
        return action;
    }

}

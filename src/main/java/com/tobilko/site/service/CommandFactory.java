package com.tobilko.site.service;

import com.tobilko.site.service.command.Command;
import com.tobilko.site.service.command.Action;

public class CommandFactory {
    public Command defineCommand(String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Action commandEnum = Action.valueOf(command.toUpperCase());
        return commandEnum.getCurrentCommand();
    }
}

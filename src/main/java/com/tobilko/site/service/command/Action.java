package com.tobilko.site.service.command;

public enum Action {

    SIGNUP      (new SignUpCommand()),
    LOGIN       (new LogInCommand()),
    LOGOUT      (new LogOutCommand());

    private final Command command;

    Action(Command command) {
        this.command = command;
    }

    public Command getCurrentCommand() {
        return command;
    }

}
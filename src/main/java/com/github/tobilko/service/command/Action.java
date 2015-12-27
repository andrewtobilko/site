package com.github.tobilko.service.command;

public enum Action {

    SIGNUP      (new SignUpCommand()),
    LOGIN       (new LogInCommand()),
    LOGOUT      (new LogOutCommand());

    private final AbstractCommand command;

    Action(AbstractCommand command) { this.command = command; }

    public AbstractCommand getCurrentCommand() { return command; }

    @Override
    public String toString() { return "Action [" + command + "]"; }
}
package com.github.tobilko.service;

public enum Command {

    LOGIN       ("login"),
    LOGOUT      ("logout"),
    SIGNUP      ("signup");

    private String name;

    Command(String name) { this.name = name; }

    public String getName() { return this.name; }

    @Override
    public String toString() { return "Command [name='" + name + "']"; }
}

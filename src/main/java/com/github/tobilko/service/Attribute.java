package com.github.tobilko.service;

public enum Attribute {

    FACTORY_COMMAND         ("factory.command"),
    FACTORY_MANAGER         ("factory.manager"),

    USER                    ("user"),

    MESSAGE_PASSWORD        ("message.password"),
    MESSAGE_EMAIL           ("message.email");

    private String name;

    Attribute(String name) { this.name = name; }

    public String getName() { return this.name; }

    @Override
    public String toString() { return "Attribute [name='" + name + "']"; }
}

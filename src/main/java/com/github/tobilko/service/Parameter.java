package com.github.tobilko.service;

public enum Parameter {

    NAME            ("name"),
    EMAIL           ("email"),
    PASSWORD        ("password");

    private String name;

    Parameter(String name) { this.name = name; }

    public String getName() { return this.name; }

    @Override
    public String toString() { return "Parameter [name='" + name + "']"; }
}

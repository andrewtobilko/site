package com.github.tobilko.service;

public enum Page {

    INDEX       ("/WEB-INF/jsp/index.jsp"),
    SIGNUP      ("/WEB-INF/jsp/signup.jsp"),
    LOGIN       ("/WEB-INF/jsp/login.jsp"),
    LOGOUT      ("/WEB-INF/jsp/logout.jsp"),
    PROFILE     ("/WEB-INF/jsp/profile.jsp");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() { return "Page [path='" + path + "']"; }
}

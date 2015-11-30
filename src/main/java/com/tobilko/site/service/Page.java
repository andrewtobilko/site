package com.tobilko.site.service;

public enum Page {

    INDEX       ("/WEB-INF/jsp/index.jsp"),
    SIGNUP      ("/WEB-INF/jsp/signup.jsp"),
    LOGIN       ("/WEB-INF/jsp/login.jsp"),
    LOGOUT      ("/WEB-INF/jsp/logout.jsp"),
    USERS       ("/WEB-INF/jsp/users.jsp");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}

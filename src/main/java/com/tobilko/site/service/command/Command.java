package com.tobilko.site.service.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    boolean execute(HttpServletRequest request);
}

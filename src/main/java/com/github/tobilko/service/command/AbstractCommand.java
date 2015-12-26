package com.github.tobilko.service.command;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand {

    public abstract boolean execute(HttpServletRequest request);

}

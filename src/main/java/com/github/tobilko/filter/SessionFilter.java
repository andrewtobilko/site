package com.github.tobilko.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/profile", "/logout"})
public class SessionFilter extends AbstractFilter {

    private final static Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("The session filter is in the processing...");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/");
        } else {
            chain.doFilter(request, response);
        }
    }
}
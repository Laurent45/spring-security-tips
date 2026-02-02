package com.boarhat.springsecuritypractice.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AuthenticationLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestId = request.getHeader("Request-Id");

        logger.info("Successfully logged in, requestId: {}", requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

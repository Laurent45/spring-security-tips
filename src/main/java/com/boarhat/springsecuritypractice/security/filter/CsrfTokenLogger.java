package com.boarhat.springsecuritypractice.security.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import java.io.IOException;

public class CsrfTokenLogger implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CsrfTokenLogger.class);
    private static final String CSRF_TOKEN_HEADER = "_csrf";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CsrfToken token = (CsrfToken) servletRequest.getAttribute(CSRF_TOKEN_HEADER);

        logger.info("CSRF Token: {}", token.getToken());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

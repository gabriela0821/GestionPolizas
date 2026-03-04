package com.seguros.polizas.interfaces.security;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter implements Filter {

    private static final String API_KEY = "123456";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = http.getRequestURI();

        if (path.contains("swagger") || path.contains("v3/api-docs") || path.contains("h2-console")) {
            chain.doFilter(request, response);
            return;
        }

        String key = http.getHeader("x-api-key");

        if (API_KEY.equals(key)) {
            chain.doFilter(request, response);
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write("{\"error\": \"Unauthorized\"}");
        }
    }
}
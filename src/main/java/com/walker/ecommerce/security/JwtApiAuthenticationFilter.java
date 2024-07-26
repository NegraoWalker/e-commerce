package com.walker.ecommerce.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtApiAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = new JwtTokenAuthenticationService().getAuthentication((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (Exception e) {
            e.printStackTrace();
            servletResponse.getWriter().write("Ocorreu um erro inesperado no sistema, erro: " + e.getMessage());
        }
    }
}

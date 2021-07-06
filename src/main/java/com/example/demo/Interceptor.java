package com.example.demo;

import com.example.demo.configurations.Configurations;
import com.example.demo.daos.DaoUser;
import com.example.demo.exceptions.UserTokenNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    Configurations configuration;
    @Autowired
    DaoUser daoUser;

    public boolean checkAuthentication(HttpServletRequest request) {
        if (configuration.getToken().contains(request.getRequestURI())) {
            return true;
        }
        String token = request.getHeader("token");
        if (token != null && daoUser.auth.containsKey(token)) {
            return true;
        } else {
            throw new UserTokenNotValidException();
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return checkAuthentication(request);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }
}
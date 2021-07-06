package com.example.demo.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "sufle.auth.bypass")
public class Configurations {

    private List<String> token;

    public Configurations() {

    }

    public List<String> getToken() {
        return token;
    }

    public void setToken(List<String> token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "token=" + token +
                '}';
    }
}
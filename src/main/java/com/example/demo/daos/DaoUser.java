package com.example.demo.daos;

import com.example.demo.EncryptUtil;
import com.example.demo.entities.User;
import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.WrongPasswordException;
import com.example.demo.models.LoginRequest;
import com.example.demo.models.Response;
import com.example.demo.repos.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DaoUser {

    public Map<String, User> auth = new HashMap<>();


    @Autowired
    RepoUser repoUser;

    @Autowired
    EncryptUtil encryptUtil;

    @Autowired
    private void init() {
        List<User> users = repoUser.findAllByTokenIsNotNull();
        for (User user : users) {
            auth.put(user.getToken(), user);
        }
    }

    public Response insert(User user, String token) {
        Optional<User> optionalUser = repoUser.findByUserName(user.getUserName());
        if (!optionalUser.isPresent()) {
            return new Response().setResponse(repoUser.save(user
                    .setPassword(encryptUtil.encrypt(user.getPassword()))
                    .setToken(localSelectByToken(token).getToken())

            ));
        }
        throw new AlreadyExistsException("This username already exists");
    }

    public Response login(LoginRequest loginRequest) {
        Optional<User> optionalUser = repoUser.findByUserNameAndPassword(
                loginRequest.getUsername(), encryptUtil.encrypt(loginRequest.getPassword())
        );
        if (optionalUser.isPresent()) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            optionalUser.get().setToken(token);
            auth.put(token, optionalUser.get());
            repoUser.save(optionalUser.get());
            return new Response().setResponse(repoUser.findById(optionalUser.get().getId()));
        }
        throw new WrongPasswordException("Username or password is wrong");
    }

    public Response checkToken(String token) {
        return new Response().setResponse(auth.get(token));
    }

    public User localSelectByToken(String token) {
        return auth.get(token);
    }

}

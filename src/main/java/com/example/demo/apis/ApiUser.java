package com.example.demo.apis;

import com.example.demo.daos.DaoUser;
import com.example.demo.entities.User;
import com.example.demo.models.LoginRequest;
import com.example.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sufle/v1/user")
public class ApiUser {

    @Autowired
    DaoUser daoUser;

    @PostMapping("/insert")
    public Response insert(@RequestBody User user, @RequestHeader String token){
        return daoUser.insert(user, token);
    }


    @PostMapping("/auth")
    public Response login(@RequestBody LoginRequest loginRequest){
        return daoUser.login(loginRequest);
    }

    @PostMapping("/checkToken")
    public Response checkToken(@RequestHeader String token) {
        return daoUser.checkToken(token);
    }


}

package com.example.demo.repos;

import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoUser extends CrudRepository<User,Long> {

    Optional<User> findByUserName(String username);
    Optional<User> findByUserNameAndPassword(String username,String password);
    List<User> findAllByTokenIsNotNull();

}

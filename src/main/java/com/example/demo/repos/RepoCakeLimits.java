package com.example.demo.repos;

import com.example.demo.entities.CakeLimit;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RepoCakeLimits extends CrudRepository<CakeLimit,Long> {

    Optional<CakeLimit> findByDate(LocalDate date);
    Optional<CakeLimit> findByDateAndType(LocalDate date,String type);

}

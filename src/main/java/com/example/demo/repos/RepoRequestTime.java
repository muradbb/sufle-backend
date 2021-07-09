package com.example.demo.repos;

import com.example.demo.entities.RequestTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoRequestTime extends CrudRepository<RequestTime,Long> {
    //
    @Query(value = "select * from request_time", nativeQuery = true)
    List<RequestTime> selectAll();

    @Query(value = "SELECT * FROM request_time WHERE :text != NULL AND LENGTH(:text) > 0 OR name LIKE %:text%", nativeQuery = true)
    Page<RequestTime> findAllByQuery(String text, Pageable pageable);

    Optional<RequestTime> findAllByType(String type);
}

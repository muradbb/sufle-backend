package com.example.demo.apis;

import com.example.demo.daos.DaoCakeLimits;
import com.example.demo.entities.CakeLimit;
import com.example.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("sufle/v1/cakeLimit")
public class ApiCakeLimit {

    @Autowired
    DaoCakeLimits daoCakeLimits;

    @PostMapping("/insert")
    public Response insert(@RequestBody CakeLimit cakeLimit){
        return daoCakeLimits.insert(cakeLimit);
    }

    @GetMapping("/selectByDate")
    public Response selectByDate(@RequestParam String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return daoCakeLimits.selectByDate(localDate);
    }

    @GetMapping("/selectById")
    public Response selectById(@RequestParam long id){
        return daoCakeLimits.selectById(id);
    }



}

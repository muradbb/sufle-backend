package com.example.demo.apis;

import com.example.demo.daos.DaoRequestTime;
import com.example.demo.entities.RequestTime;
import com.example.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sufle/v1/requestTime")
public class ApiRequestTime {

    @Autowired
    DaoRequestTime daoRequestTime;

    @PostMapping("/insert")
    public Response insert(@RequestBody RequestTime requestTime) {
        return daoRequestTime.insert(requestTime);
    }

    @GetMapping("/selectAll")
    public Response selectAll(){
        return daoRequestTime.selectAll();
    }

    @GetMapping("/selectByType")
    public Response selectByType(@RequestParam String type){
        return daoRequestTime.selectByType(type);
    }

    @GetMapping("/selectBy")
    public Response selectBy(@RequestParam String query,
                             @RequestParam Integer limit,
                             @RequestParam Integer ascending,
                             @RequestParam Integer page,
                             @RequestParam(required = false) String orderBy) {
        return daoRequestTime.selectBy(query, limit, ascending, page, orderBy);
    }

}

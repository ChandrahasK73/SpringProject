package com.org.project;

import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Resource
    private MongoTemplate mongoTemplate;
    @PostMapping(path="employee", consumes = "application/json")
    public String createEmployee(@RequestBody Employee employee){
        System.out.println(employee.getEmpName());
        mongoTemplate.save(employee);
        return employee.getEmpId();
    }
    @GetMapping(path="employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id){
        return mongoTemplate.findById(id, Employee.class);
    }
}

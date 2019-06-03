package com.lambdaschool.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/calc/salary/1/0.5
@RestController
@RequestMapping("/calc")
public class CalculationController
{
    @RequestMapping(value = "/salary/{id}/{raise}",
                    produces = {"application/json"})
    public ResponseEntity<?> checkRaise(
            @PathVariable
                    long id,
            @PathVariable
                    double raise)
    {

        // the following line is wrong
        // Employee tempEmp = WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id));

        // the following line is correct
        Employee tempEmp = new Employee(WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id)));
        tempEmp.setSalary(tempEmp.getSalary() * (1.0 + raise));
        return new ResponseEntity<>(tempEmp, HttpStatus.OK);
    }
}

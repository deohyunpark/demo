package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @GetMapping("/{employeeId}")
    public void employeeInfo(@PathVariable Integer employeeId) {


    }

    @GetMapping("/{employeeId}/history")
    public void employeeHistory(@PathVariable Integer employeeId) {


    }

}

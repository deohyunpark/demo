package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    @GetMapping
    public void departmentInfoAndLocation() {


    }

    @GetMapping("/{departmentId}/salary-increase")
    public void SalaryUpdate(@PathVariable Integer departmentId) {


    }

}

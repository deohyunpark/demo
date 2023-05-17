package com.example.demo.controller;


import com.example.demo.controller.response.EmployeeResponse;
import com.example.demo.controller.response.HistoryResponse;
import com.example.demo.controller.response.Response;
import com.example.demo.model.Employee;
import com.example.demo.model.JobHistory;
import com.example.demo.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
@ApiOperation(value = "사원 별 현재 정보 및 이력 조회")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @ApiOperation(value = "특정 사원의 현재 정보 조회 API")
    public Response<EmployeeResponse> employeeInfo(@PathVariable Integer employeeId) {

        Employee employee = employeeService.selectEmployee(employeeId);

        return Response.success(EmployeeResponse.fromEmployee(employee));
    }

    @GetMapping("/{employeeId}/history")
    @ApiOperation(value = "특정 사원의 이력 정보 조회 API")

    public Response<List<HistoryResponse>> employeeHistory(@PathVariable Integer employeeId) {

        List<JobHistory> history = employeeService.employeeHistory(employeeId);

        return Response.success(HistoryResponse.fromHistories(history));
    }

}

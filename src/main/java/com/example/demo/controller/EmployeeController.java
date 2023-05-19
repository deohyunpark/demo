package com.example.demo.controller;


import com.example.demo.controller.response.EmployeeResponse;
import com.example.demo.controller.response.HistoryResponse;
import com.example.demo.controller.response.Response;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.Employee;
import com.example.demo.model.JobHistory;
import com.example.demo.service.EmployeeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
@ApiOperation(value = "사원 별 현재 정보 및 이력 조회")
@Tag(name = "employee", description = "사원 API")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @Operation(summary = "특정 사원의 현재 정보 조회 API" , description =  "사원번호를 통해 해당 사원의 정보를 조회한다.",
    responses = { @ApiResponse(responseCode = "200", description = "사원 정보 조회 성공", content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "해당 사번의 사원이 존재하지않음", content = @Content(schema = @Schema(implementation = ErrorCode.class))),
            @ApiResponse(responseCode = "400", description = "서버 내부 에러", content = @Content(schema = @Schema(implementation = ErrorCode.class)))})
    @ApiImplicitParam(name = "employeeId", value = "사원번호", dataType = "Integer", paramType = "path")
    public Response<EmployeeResponse> employeeInfo(@PathVariable Integer employeeId) {

        Employee employee = employeeService.selectEmployee(employeeId);

        return Response.success(EmployeeResponse.fromEmployee(employee));
    }

    @GetMapping("/{employeeId}/history")
    @ApiOperation(value = "특정 사원의 이력 정보 조회 API", notes = "사원번호를 통해 해당 사원의 이력 정보를 조회한다.")
    @ApiImplicitParam(name = "employeeId", value = "사원번호", dataType = "Integer", paramType = "path")
    public Response<List<HistoryResponse>> employeeHistory(@PathVariable Integer employeeId) {

        List<JobHistory> history = employeeService.employeeHistory(employeeId);

        return Response.success(HistoryResponse.fromHistories(history));
    }

}

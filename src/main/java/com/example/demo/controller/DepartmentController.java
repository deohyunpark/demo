package com.example.demo.controller;


import com.example.demo.controller.response.DepartmentResponse;
import com.example.demo.controller.response.Response;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/departments")
@RequiredArgsConstructor
@ApiOperation(value = "부서 관련 정보조회 및 급여수정")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @ApiOperation(value = "부서 및 위치 정보 조회 API")
    public Response<List<DepartmentResponse>> departmentInfoAndLocation() {

        List<Department> list = departmentService.Info();

        return Response.success(DepartmentResponse.fromDepartments(list));
    }

    @GetMapping("/{departmentId}/salary-increase")
    @ApiOperation(value = "부서 별 급여 인상 및 사원 정보 업데이트 API")
    public void SalaryUpdate(@PathVariable Integer departmentId) {

        departmentService.salaryUpdate(departmentId);

    }

}

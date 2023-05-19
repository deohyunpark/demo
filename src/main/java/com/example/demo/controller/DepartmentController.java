package com.example.demo.controller;


import com.example.demo.controller.response.DepartmentResponse;
import com.example.demo.controller.response.Response;
import com.example.demo.controller.response.SalaryUpdateResponse;
import com.example.demo.model.Department;
import com.example.demo.model.SalaryUpdatedList;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/departments")
@RequiredArgsConstructor
@ApiOperation(value = "부서 관련 정보조회 및 급여수정")
@Tag(name = "department", description = "부서 API")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @ApiOperation(value = "부서 및 위치 정보 조회 API")
    public Response<List<DepartmentResponse>> departmentInfoAndLocation() {

        List<Department> list = departmentService.Info();

        return Response.success(DepartmentResponse.fromDepartments(list));
    }

    @PutMapping("/{departmentId}/salary-increase/{percent}")
    @ApiOperation(value = "부서 별 급여 인상 및 사원 정보 업데이트 API")
    public Response<List<SalaryUpdateResponse>> SalaryUpdate(@PathVariable Integer departmentId, @PathVariable double percent) {
        List<SalaryUpdatedList> list = departmentService.salaryUpdate(departmentId, percent);

        return Response.success(SalaryUpdateResponse.fromUpdateLists(list));

    }

}

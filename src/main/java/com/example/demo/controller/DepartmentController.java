package com.example.demo.controller;


import com.example.demo.controller.response.DepartmentResponse;
import com.example.demo.controller.response.Response;
import com.example.demo.controller.response.SalaryUpdateResponse;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.Department;
import com.example.demo.model.SalaryUpdatedList;
import com.example.demo.service.DepartmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/departments")
@RequiredArgsConstructor
@ApiOperation(value = "부서 관련 정보조회 및 급여수정")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(summary = "부서 및 위치 정보 조회 API" , description =  "전체 부서의 위치와 정보 조회.",
            responses = { @ApiResponse(responseCode = "200", description = "전체 부서 조회 성공"),
                    @ApiResponse(responseCode = "500", description = "서버 내부 에러",content = @Content(schema = @Schema(implementation = ErrorCode.class)))})
    @GetMapping
    public Response<List<DepartmentResponse>> departmentInfoAndLocation() {

        List<Department> list = departmentService.Info();

        return Response.success(DepartmentResponse.fromDepartments(list));
    }

    @Operation(summary = "부서 별 급여 인상 및 사원 정보 업데이트 API" , description =  "급여를 인상하려는 부서번호와 급여인상퍼센트((ex) 0.1, 0.5) 입력하여 해당 부서 급여 인상 및 사원 정보 업데이트).",
            responses = { @ApiResponse(responseCode = "200", description = "급여 인상 성공 및 정보 업데이트 완료"),
                    @ApiResponse(responseCode = "400", description = "인상하려는 급여 퍼센트가 적절한 값이 아님(정수입력불가)", content = @Content(schema = @Schema(implementation = ErrorCode.class))),
                    @ApiResponse(responseCode = "404", description = "해당 부서가 존재하지 않음", content = @Content(schema = @Schema(implementation = ErrorCode.class))),
                    @ApiResponse(responseCode = "500", description = "서버 내부 에러",content = @Content(schema = @Schema(implementation = ErrorCode.class)))})
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "departmentId", value = "부서번호", dataType = "Integer", paramType = "path",required = true, dataTypeClass = Integer.class, example = "0"),
                    @ApiImplicitParam(name = "percent", value = "월급인상률(EX - 0.1, 0.4)", dataType = "double", paramType = "path",required = true, dataTypeClass = Double.class, example = "0")})
    @PutMapping("/{departmentId}/salary-increase/{percent}")
    public Response<List<SalaryUpdateResponse>> SalaryUpdate(@PathVariable Integer departmentId, @PathVariable double percent) {
        List<SalaryUpdatedList> list = departmentService.salaryUpdate(departmentId, percent);

        return Response.success(SalaryUpdateResponse.fromUpdateLists(list));

    }

}

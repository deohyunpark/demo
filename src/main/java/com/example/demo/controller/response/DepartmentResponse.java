package com.example.demo.controller.response;

import com.example.demo.model.Department;
import com.example.demo.model.LocationInfo;
import com.example.demo.model.ManagerInfo;
import com.example.demo.model.entity.DepartmentEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {

    @ApiModelProperty(example = "부서코드")
    private Integer departmentId;

    @ApiModelProperty(example = "부서이름")
    private String departmentName;

    @ApiModelProperty(example = "매니저 정보")
    private ManagerInfo managerInfo;

    @ApiModelProperty(example = "지역 정보")
    private LocationInfo location;


    //manager 가 있는경우
    public static DepartmentResponse fromDepartment(Department department) {
        return DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .managerInfo(department.getManagerInfo())
                .location(department.getLocation())
                .build();

    }
    //manager 가 없는경우
    public static DepartmentResponse fromDepartmentExcludeManager(Department department) {
        return DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .location(department.getLocation())
                .build();

    }

    public static List<DepartmentResponse> fromDepartments(List<Department> departments) {
        List<DepartmentResponse> entities = new ArrayList<>();

        departments.stream()
                .filter( department -> department.getManagerInfo() != null)
                .map(DepartmentResponse::fromDepartment)
                .forEach(entities::add);

        departments.stream()
                .filter( department -> department.getManagerInfo() == null)
                .map(DepartmentResponse::fromDepartmentExcludeManager)
                .forEach(entities::add);

        return entities;
    }
}

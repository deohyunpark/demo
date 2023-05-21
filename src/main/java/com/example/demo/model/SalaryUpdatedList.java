package com.example.demo.model;

import com.example.demo.model.entity.EmployeeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryUpdatedList {
    @ApiModelProperty(example = "부서별 급여 인상자 사원번호")
    private Integer employeeId;

    @ApiModelProperty(example = "부서별 급여 인상자 이름")
    private String employeeName;

    @ApiModelProperty(example = "부서별 급여 인상자 직종")
    private String jobTitle;

    @ApiModelProperty(example = "인상된 최종 급여")
    private BigDecimal salary;

    public static SalaryUpdatedList fromEntity(EmployeeEntity entity) {
        return SalaryUpdatedList.builder()
                .employeeId(entity.getEmployeeId())
                .employeeName(entity.getFirstName() + " " + entity.getLastName())
                .jobTitle(entity.getJobId().getJobTitle())
                .salary(entity.getSalary()).build();
    }

    public static List<SalaryUpdatedList> fromEntities(List<EmployeeEntity> list) {
        List<SalaryUpdatedList> updatedLists = new ArrayList<>();
        list.forEach( l -> updatedLists.add(SalaryUpdatedList.fromEntity(l)));
        return updatedLists;
    }
}

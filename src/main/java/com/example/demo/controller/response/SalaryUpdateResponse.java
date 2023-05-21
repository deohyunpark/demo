package com.example.demo.controller.response;

import com.example.demo.model.SalaryUpdatedList;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryUpdateResponse {

    @ApiModelProperty(example = "부서별 급여 인상자 사원번호")
    private Integer employeeId;

    @ApiModelProperty(example = "부서별 급여 인상자 이름")
    private String employeeName;

    @ApiModelProperty(example = "부서별 급여 인상자 직종")
    private String jobTitle;

    @ApiModelProperty(example = "인상된 최종 급여")
    private BigDecimal salary;

    public static SalaryUpdateResponse fromUpdateList(SalaryUpdatedList list) {
        return SalaryUpdateResponse.builder()
                .employeeId(list.getEmployeeId())
                .employeeName(list.getEmployeeName())
                .jobTitle(list.getJobTitle())
                .salary(list.getSalary()).build();
    }

    public static List<SalaryUpdateResponse> fromUpdateLists(List<SalaryUpdatedList> list) {
        List<SalaryUpdateResponse> updatedLists = new ArrayList<>();
        list.forEach( l -> updatedLists.add(SalaryUpdateResponse.fromUpdateList(l)));
        return updatedLists;
    }
}

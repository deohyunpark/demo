package com.example.demo.controller.response;

import com.example.demo.model.SalaryUpdatedList;
import com.example.demo.model.entity.EmployeeEntity;
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

    private Integer employeeId;

    private String employeeName;

    private String jobTitle;

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

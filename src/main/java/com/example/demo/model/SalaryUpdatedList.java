package com.example.demo.model;

import com.example.demo.model.entity.EmployeeEntity;
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

    private Integer employeeId;

    private String employeeName;

    private String jobTitle;

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

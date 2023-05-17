package com.example.demo.model;

import com.example.demo.model.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerInfo {

    private Integer employeeId;

    private String managerName;

    private String managerJobTitle;

    private String managerEmail;

    private String managerPhoneNumber;

    public static ManagerInfo managerInfo(DepartmentEntity department) {
        return ManagerInfo.builder()
                .employeeId(department.getManagerId().getEmployeeId())
                .managerName(department.getManagerId().getFirstName() + " " + department.getManagerId().getLastName())
                .managerJobTitle(department.getManagerId().getJobId().getJobTitle())
                .managerEmail(department.getManagerId().getEmail())
                .managerPhoneNumber(department.getManagerId().getPhoneNumber())
                .build();
    }
}

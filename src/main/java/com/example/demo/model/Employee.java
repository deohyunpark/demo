package com.example.demo.model;

import com.example.demo.model.entity.DepartmentEntity;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.entity.JobEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Employee {

    private Integer employeeId;

    private String employeeName;

    private String email;

    private String phoneNumber;

    private Date hireDate;

    private String jobTitle;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    private String departmentName;

    private String city;

    private String stateProvince;

    private String countryName;

    private String regionName;

    private String managerName;


    public static Employee fromEmployee(EmployeeEntity entity, DepartmentEntity department) {
        return Employee.builder()
                .employeeId(entity.getEmployeeId())
                .employeeName(entity.getFirstName() + " " + entity.getLastName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .hireDate(entity.getHireDate())
                .jobTitle(entity.getJobId().getJobTitle())
                .salary(entity.getSalary())
                .commissionPct(entity.getCommissionPct())
                .departmentName(entity.getDepartmentId().getDepartmentName())
                .city(department.getLocationId().getCity())
                .stateProvince(department.getLocationId().getStateProvince())
                .countryName(department.getLocationId().getCountryId().getCountryName())
                .regionName(department.getLocationId().getCountryId().getRegionId().getRegionName())
                .managerName(entity.getManagerId().getFirstName() + " " + entity.getManagerId().getLastName())
                .build();
    }

}

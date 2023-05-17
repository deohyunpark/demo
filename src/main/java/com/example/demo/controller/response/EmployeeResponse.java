package com.example.demo.controller.response;

import com.example.demo.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

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

    public static EmployeeResponse fromEmployee(Employee employee) {
        return EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .email(employee.getEmail())
                .city(employee.getCity())
                .commissionPct(employee.getCommissionPct())
                .countryName(employee.getCountryName())
                .hireDate(employee.getHireDate())
                .jobTitle(employee.getJobTitle())
                .phoneNumber(employee.getPhoneNumber())
                .regionName(employee.getRegionName())
                .managerName(employee.getManagerName())
                .stateProvince(employee.getStateProvince())
                .salary(employee.getSalary())
                .departmentName(employee.getDepartmentName())
                .build();

    }

}

package com.example.demo.controller.response;

import com.example.demo.model.Employee;
import com.example.demo.model.ManagerInfo;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(example = "사원번호")
    private Integer employeeId;

    @ApiModelProperty(example = "사원명")
    private String employeeName;

    @ApiModelProperty(example = "이메일")
    private String email;

    @ApiModelProperty(example = "핸드폰번호")
    private String phoneNumber;

    @ApiModelProperty(example = "입사날")
    private Date hireDate;

    @ApiModelProperty(example = "직종")
    private String jobTitle;

    @ApiModelProperty(example = "급여")
    private BigDecimal salary;

    @ApiModelProperty(example = "인센티브퍼센트")
    private BigDecimal commissionPct;

    @ApiModelProperty(example = "부서명")
    private String departmentName;

    @ApiModelProperty(example = "시")
    private String city;

    @ApiModelProperty(example = "행정구역")
    private String stateProvince;

    @ApiModelProperty(example = "나라명")
    private String countryName;

    @ApiModelProperty(example = "지역명")
    private String regionName;

    @ApiModelProperty(example = "매니저 정보")
    private ManagerInfo managerInfo;

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
                .managerInfo(employee.getManager())
                .stateProvince(employee.getStateProvince())
                .salary(employee.getSalary())
                .departmentName(employee.getDepartmentName())
                .build();

    }

}

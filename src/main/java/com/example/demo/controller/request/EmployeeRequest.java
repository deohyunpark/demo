//package com.example.demo.controller.request;
//
//import com.example.demo.model.Employee;
//import com.example.demo.model.entity.EmployeeEntity;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Getter
//public class EmployeeRequest {
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;
//
//    private String phoneNumber;
//
//    private Date hireDate;
//
//    private String jobId;
//
//    private BigDecimal salary;
//
//    private BigDecimal commissionPct;
//
//    private EmployeeEntity managerId;
//
//    private String departmentId;
//
//
//    public static Employee fromEmployee(EmployeeEntity entity) {
//        return Employee.builder()
//                .firstName(entity.getFirstName())
//                .lastName(entity.getLastName())
//                .email(entity.getEmail())
//                .phoneNumber(entity.getPhoneNumber())
//                .hireDate(entity.getHireDate())
//                .jobId(entity.getJobId().getJobTitle())
//                .salary(entity.getSalary())
//                .commissionPct(entity.getCommissionPct())
//                .managerId(entity.getManagerId())
//                .departmentId(entity.getDepartmentId().getDepartmentName())
//                .build();
//    }
//
//}

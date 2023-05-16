package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
public class EmployeeEntity {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String email;

    @Setter
    private String phoneNumber;

    @Setter
    private Date hireDate;

    @Setter
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity jobId;

    @Setter
    private BigDecimal salary;

    @Setter
    private BigDecimal commissionPct;

    @Setter
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity managerId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentId;


}


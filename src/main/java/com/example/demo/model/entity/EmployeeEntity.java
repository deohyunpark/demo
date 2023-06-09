package com.example.demo.model.entity;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "job_id")
    private JobEntity jobId;

    @Setter
    private BigDecimal salary;

    @Setter
    private BigDecimal commissionPct;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id", referencedColumnName = "employee_id",insertable = false, updatable = false)
    private EmployeeEntity managerId;


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentId;


}


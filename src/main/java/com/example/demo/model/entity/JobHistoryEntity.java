package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "job_history")
@Getter
public class JobHistoryEntity {

    @Id
    @Column(name = "employee_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeId;

    @Setter
    private Date startDate;

    @Setter
    private Date endDate;

    @Setter
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity jobId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentId;

}

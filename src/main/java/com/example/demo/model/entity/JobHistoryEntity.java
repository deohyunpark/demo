package com.example.demo.model.entity;

import com.example.demo.model.JobHistoryId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_history")
@Getter
public class JobHistoryEntity {

    @EmbeddedId
    private JobHistoryId id;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeId;



    @Setter
    private Date startDate;

    @Setter
    private Date endDate;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    private JobEntity jobId;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentId;

}

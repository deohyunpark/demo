package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class JobHistoryId implements Serializable {

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "department_id")
    private Integer departmentId;

    public JobHistoryId(Integer employeeId, String jobId, Integer departmentId) {
        this.employeeId = employeeId;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }
}

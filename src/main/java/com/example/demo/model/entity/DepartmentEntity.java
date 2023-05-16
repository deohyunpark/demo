package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
public class DepartmentEntity {

    @Id
    private Integer departmentId;

    @Setter
    private String departmentName;

    @Setter
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private EmployeeEntity managerId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity locationId;

}

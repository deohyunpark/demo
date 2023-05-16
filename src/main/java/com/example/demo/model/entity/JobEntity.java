package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@Getter
public class JobEntity {

    @Id
    private String jobId;

    @Setter
    private String jobTitle;

    @Setter
    private BigDecimal minSalary;

    @Setter
    private BigDecimal maxSalary;

}

package com.example.demo.model;

import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.entity.JobHistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobHistory {

    private Integer employeeId;

    private String employeeName;

    private Date startDate;

    private Date endDate;

    private String jobTitle;

    private String departmentTitle;


    public static JobHistory fromEntity(JobHistoryEntity entity) {

        return JobHistory.builder()
                .employeeId(entity.getEmployeeId().getEmployeeId())
                .employeeName(entity.getEmployeeId().getFirstName() + " " + entity.getEmployeeId().getLastName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .jobTitle(entity.getJobId().getJobTitle())
                .departmentTitle(entity.getDepartmentId().getDepartmentName())
                .build();

    }

    public static List<JobHistory> fromEntities(List<JobHistoryEntity> entity) {

        List<JobHistory> histories = new ArrayList<>();
        entity.forEach(l -> histories.add(JobHistory.fromEntity(l)));
        return histories;

    }


}

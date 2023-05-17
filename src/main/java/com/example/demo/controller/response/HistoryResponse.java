package com.example.demo.controller.response;

import com.example.demo.model.JobHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryResponse {

    private Integer employeeId;

    private String employeeName;

    private Date startDate;

    private Date endDate;

    private String jobTitle;

    private String departmentTitle;

    public static HistoryResponse fromHistory(JobHistory history) {
        return HistoryResponse.builder()
                .employeeId(history.getEmployeeId())
                .employeeName(history.getEmployeeName())
                .startDate(history.getStartDate())
                .endDate(history.getEndDate())
                .jobTitle(history.getJobTitle())
                .departmentTitle(history.getDepartmentTitle())
                .build();


    }
}

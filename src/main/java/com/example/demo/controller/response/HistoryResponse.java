package com.example.demo.controller.response;

import com.example.demo.model.JobHistory;
import io.swagger.annotations.ApiModelProperty;
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
public class HistoryResponse {

    @ApiModelProperty(example = "사원번호")
    private Integer employeeId;

    @ApiModelProperty(example = "사원명")
    private String employeeName;

    @ApiModelProperty(example = "입사일자")
    private Date startDate;

    @ApiModelProperty(example = "퇴사일자")
    private Date endDate;

    @ApiModelProperty(example = "직종")
    private String jobTitle;

    @ApiModelProperty(example = "부서명")
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

    public static List<HistoryResponse> fromHistories(List<JobHistory> histories) {
        List<HistoryResponse> responses = new ArrayList<>();
        histories.forEach(l -> responses.add(HistoryResponse.fromHistory(l)));

        return responses;
    }
}

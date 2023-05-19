package com.example.demo.model;

import com.example.demo.model.entity.DepartmentEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerInfo {

    @ApiModelProperty(example = "매니저 사원번호")
    private Integer employeeId;

    @ApiModelProperty(example = "매니저 이름")
    private String managerName;

    @ApiModelProperty(example = "매니저 직종")
    private String managerJobTitle;

    @ApiModelProperty(example = "매니저 이메일")
    private String managerEmail;

    @ApiModelProperty(example = "매니저 핸드폰번호")
    private String managerPhoneNumber;

    public static ManagerInfo managerInfo(DepartmentEntity department) {
        return ManagerInfo.builder()
                .employeeId(department.getManagerId().getEmployeeId())
                .managerName(department.getManagerId().getFirstName() + " " + department.getManagerId().getLastName())
                .managerJobTitle(department.getManagerId().getJobId().getJobTitle())
                .managerEmail(department.getManagerId().getEmail())
                .managerPhoneNumber(department.getManagerId().getPhoneNumber())
                .build();
    }
}

package com.example.demo.controller.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryIncreaseRequest {
    @ApiModelProperty(example = "급여인상퍼센트")
    private double percent;
}

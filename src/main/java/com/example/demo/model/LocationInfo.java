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
public class LocationInfo {

    @ApiModelProperty(example = "도로명주소")
    private String streetAddress;

    @ApiModelProperty(example = "우편번호")
    private String postalCode;

    @ApiModelProperty(example = "시")
    private String city;

    @ApiModelProperty(example = "행정구역")
    private String stateProvince;

    @ApiModelProperty(example = "나라명")
    private String country;

    @ApiModelProperty(example = "지역명")
    private String region;

    public static LocationInfo locationInfo(DepartmentEntity entity) {
        return LocationInfo.builder()
                .streetAddress(entity.getLocationId().getStreetAddress())
                .postalCode(entity.getLocationId().getPostalCode())
                .city(entity.getLocationId().getCity())
                .stateProvince(entity.getLocationId().getStateProvince())
                .country(entity.getLocationId().getCountryId().getCountryName())
                .region(entity.getLocationId().getCountryId().getRegionId().getRegionName())
                .build();
    }
}

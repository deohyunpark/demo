package com.example.demo.model;

import com.example.demo.model.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationInfo {

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    private String country;

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

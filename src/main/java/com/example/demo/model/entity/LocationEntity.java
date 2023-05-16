package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
public class LocationEntity {

    @Id
    private Integer locationId;

    @Setter
    private String streetAddress;

    @Setter
    private String postalCode;

    @Setter
    private String city;

    @Setter
    private String stateProvince;

    @Setter
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryId;

}

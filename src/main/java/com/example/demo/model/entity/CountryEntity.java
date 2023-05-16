package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Getter
public class CountryEntity {

    @Id
    private String countryId;

    @Setter
    private String countryName;

    @Setter
    @ManyToOne
    @JoinColumn(name = "region_id")
    private RegionEntity regionId;

}

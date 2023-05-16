package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "regions")
@Getter
public class RegionEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer regionId;

    @Setter private String regionName;
}

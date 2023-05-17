package com.example.demo.model;

import com.example.demo.model.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    //select all 해서 전체를 가져옴

    //department들을 DTO로 변환

    private Integer departmentId;

    private String departmentName;

    private ManagerInfo managerInfo;

    private LocationInfo location;


    //manager 가 있는경우
    public static Department fromEntity(DepartmentEntity department) {
        return Department.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .managerInfo(ManagerInfo.managerInfo(department))
                .location(LocationInfo.locationInfo(department))
                .build();

    }
    //manager 가 없는경우
    public static Department fromEntityExcludeManager(DepartmentEntity department) {
        return Department.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .location(LocationInfo.locationInfo(department))
                .build();

    }

    public static List<Department> fromEntities(List<DepartmentEntity> departments) {
        List<Department> entities = new ArrayList<>();

        departments.stream()
                .filter( department -> department.getManagerId() != null)
                .map(Department::fromEntity)
                .forEach(entities::add);

        departments.stream()
                .filter( department -> department.getManagerId() == null)
                .map(Department::fromEntityExcludeManager)
                .forEach(entities::add);

        return entities;
    }
}

package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.entity.DepartmentEntity;
import com.example.demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> Info() {

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        return Department.fromEntities(departmentEntities);
    }

    public void salaryUpdate(Integer departmentId) {

        //부서별 급여 인상 및 업데이트
        //해당 부서 리스트 가져오기 -> employee 에서 departmentId 조회 (Cascade??)
        //
    }
}

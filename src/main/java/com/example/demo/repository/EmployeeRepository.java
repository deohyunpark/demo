package com.example.demo.repository;

import com.example.demo.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Override
    @EntityGraph(attributePaths = {"employeeId","departmentId", "jobId"})
    Optional<EmployeeEntity> findById(Integer integer);
}

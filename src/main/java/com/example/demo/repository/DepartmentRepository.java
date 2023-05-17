package com.example.demo.repository;

import com.example.demo.model.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {

    @Override
    @EntityGraph(attributePaths = {"managerId","locationId"})
    Optional<DepartmentEntity> findById(Integer integer);

    @Override
    @EntityGraph(attributePaths = {"managerId","locationId"})
    List<DepartmentEntity> findAll();
}

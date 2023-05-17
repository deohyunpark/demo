package com.example.demo.repository;

import com.example.demo.model.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}

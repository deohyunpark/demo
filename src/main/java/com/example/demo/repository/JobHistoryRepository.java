package com.example.demo.repository;

import com.example.demo.model.entity.CountryEntity;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.entity.JobHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistoryEntity, Integer> {

    List<JobHistoryEntity> findAllByEmployeeId(EmployeeEntity employeeId);
    @Query(value = "SELECT * from job_history history where history.employee_id =:employeeId", nativeQuery = true)
    List<JobHistoryEntity> findAllByEmployeeId(@Param("employeeId") Integer employeeId);


}

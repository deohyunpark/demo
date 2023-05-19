package com.example.demo.repository;

import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.entity.JobEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Override
    @EntityGraph(attributePaths = {"employeeId","departmentId", "jobId"})
    Optional<EmployeeEntity> findById(Integer integer);

    @Query("select entity from EmployeeEntity entity where entity.departmentId.departmentId = :departmentId")
    List<EmployeeEntity> findAllByDepartmentId(@Param("departmentId") Integer departmentId);

    @Modifying(clearAutomatically = true)
    @Query("update EmployeeEntity entity set entity.salary = entity.salary + (entity.salary * :salary) where entity.departmentId.departmentId = :departmentId")
    void bulkSalaryIncrease(@Param("departmentId") Integer departmentId, @Param("salary") BigDecimal salary);
    //최고급여
    Optional<EmployeeEntity> findTopByJobIdOrderBySalaryDesc(JobEntity jobId);
    //최저급여
    Optional<EmployeeEntity> findTopByJobIdOrderBySalaryAsc(JobEntity jobId);

}

package com.example.demo.service;

import com.example.demo.exception.DemoApplicationException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.SalaryUpdatedList;
import com.example.demo.model.entity.DepartmentEntity;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.entity.JobEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.google.common.math.DoubleMath;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public List<Department> Info() {

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        return Department.fromEntities(departmentEntities);
    }
    @Transactional
    public List<SalaryUpdatedList> salaryUpdate(Integer departmentId, double percent) {

        departmentRepository.findByDepartmentId(departmentId).orElseThrow(() ->
                new DemoApplicationException(ErrorCode.DEPARTMENT_NOT_FOUND, String.format("not exist department id = %s", departmentId)));
        //급여인상률이 소수점이 아닌 정수..일경우..
        if (isInteger(percent)) {
            throw new DemoApplicationException(ErrorCode.SALARY_INCREASE_PERCENT_IS_NOT_ACCEPTABLE,
                    String.format("%s is not acceptable value", percent));
        }

        //부서별 급여 인상 및 업데이트 ** employees table 의 salary , job table 의 max-sal min-sal **
        employeeRepository.bulkSalaryIncrease(departmentId, percentage(percent));

        List<EmployeeEntity> udtDepList = employeeRepository.findAllByDepartmentId(departmentId);
        //직업별 최고 급여인사람찾고 set?

        Stream<EmployeeEntity> maxEmployee = udtDepList.stream().filter(this::maxCheck);
        maxEmployee.forEach( l-> {
            l.getJobId().setMaxSalary(l.getSalary());
            employeeRepository.save(l);
        });

        Stream<EmployeeEntity> minEmployee = udtDepList.stream().filter(this::maxCheck);
        minEmployee.forEach(l-> {
            l.getJobId().setMinSalary(l.getSalary());
            employeeRepository.save(l);
        });

        return SalaryUpdatedList.fromEntities(udtDepList);
    }


    public boolean maxCheck(EmployeeEntity entity) {
        //직업 별 최고 급여인 사람 찾기
        //직업
        JobEntity job = entity.getJobId();
        //기존 최고 급여
        BigDecimal maxSalary = entity.getJobId().getMaxSalary();
        //Update 후 최고 급여
        BigDecimal updatedSalary = employeeRepository.findTopByJobIdOrderBySalaryDesc(job).get().getSalary();
        return updatedSalary.compareTo(maxSalary) == 1;
//            entity.getJobId().setMaxSalary(entity.getSalary());
    }

    public boolean minCheck(EmployeeEntity entity) {
        //직업 별 최저 급여 비교
        //직업
        JobEntity job = entity.getJobId();
        //기존 최고 급여
        BigDecimal minSalary = entity.getJobId().getMinSalary();
        //Update 후 최저 급여
        BigDecimal updatedSalary = employeeRepository.findTopByJobIdOrderBySalaryAsc(job).get().getSalary();
        return updatedSalary.compareTo(minSalary) == -1;
//            entity.getJobId().setMaxSalary(entity.getSalary());
    }

    //double -> BigDecimal
    public BigDecimal percentage(double percent) {
        return BigDecimal.valueOf(percent) ;
    }

    //Integer 인지 체크
    public boolean isInteger(double num) {
        return DoubleMath.isMathematicalInteger(num);
    }
}

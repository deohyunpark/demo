package com.example.demo.service;

import com.example.demo.exception.DemoApplicationException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.model.Employee;
import com.example.demo.model.entity.DepartmentEntity;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.JobHistory;
import com.example.demo.model.entity.JobHistoryEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final JobHistoryRepository jobHistoryRepository;

    public Employee selectEmployee(Integer employeeId)  {
        //사원번호로 조회 시 DB에 데이터가 없을 경우 예외처리
        EmployeeEntity entity = employeeRepository.findById(employeeId).orElseThrow(
                () -> new DemoApplicationException(ErrorCode.EMPLOYEE_NOT_FOUND, String.format("%s is not founded", employeeId)));

        Optional<DepartmentEntity> department = departmentRepository.findById(entity.getDepartmentId().getDepartmentId());
        return Employee.fromEmployee(entity, department.orElseThrow());

    }

    public List<JobHistory> employeeHistory(Integer employeeId) {
        //사원 조회
        employeeRepository.findById(employeeId).orElseThrow(
                () -> new DemoApplicationException(ErrorCode.EMPLOYEE_NOT_FOUND, String.format("%s is not founded", employeeId)));

        List<JobHistoryEntity> jobHistory = jobHistoryRepository.findAllById(employeeId);
        //해당 사원의 이력이 존재하지 않을 시 에러 반환
        if (jobHistory.isEmpty()) {
            throw new DemoApplicationException(ErrorCode.HISTORY_NOT_EXIST, String.format("%s 's history is not exist", employeeId));
        }

        

        return JobHistory.fromEntity(jobHistory);

    }
}

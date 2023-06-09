package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "server occur error"),
    EMPLOYEE_NOT_FOUND(HttpStatus.NOT_FOUND,"employee not founded"),

    HISTORY_NOT_EXIST(HttpStatus.NOT_FOUND, "employee's history is not exist"),

    SALARY_INCREASE_PERCENT_IS_NOT_ACCEPTABLE(HttpStatus.BAD_REQUEST, "increase percent is not acceptable"),

    DEPARTMENT_NOT_FOUND(HttpStatus.NOT_FOUND,"department not founded"),

    ;

    private HttpStatus status;
    private String message;
}

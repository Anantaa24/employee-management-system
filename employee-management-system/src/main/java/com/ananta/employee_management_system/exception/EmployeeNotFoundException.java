package com.ananta.employee_management_system.exception;

import com.ananta.employee_management_system.entity.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}

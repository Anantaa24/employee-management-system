package com.ananta.employee_management_system.service;

import com.ananta.employee_management_system.dto.EmployeeRequest;
import com.ananta.employee_management_system.dto.EmployeeResponse;
import com.ananta.employee_management_system.entity.Employee;
import com.ananta.employee_management_system.repository.EmployeeRepository;


import java.util.List;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);

    void deleteEmployee(Long id);
}

package com.ananta.employee_management_system.controller;

import com.ananta.employee_management_system.dto.EmployeeRequest;
import com.ananta.employee_management_system.dto.EmployeeResponse;
import com.ananta.employee_management_system.entity.Employee;
import com.ananta.employee_management_system.service.EmployeeService;
import com.ananta.employee_management_system.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponse saveEmployee(@Valid @RequestBody EmployeeRequest request){
        return employeeService.saveEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable  Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeRequest request){
        return employeeService.updateEmployee(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}

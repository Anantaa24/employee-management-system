package com.ananta.employee_management_system.service.impl;

import com.ananta.employee_management_system.dto.EmployeeRequest;
import com.ananta.employee_management_system.dto.EmployeeResponse;
import com.ananta.employee_management_system.entity.Employee;
import com.ananta.employee_management_system.exception.EmployeeNotFoundException;
import com.ananta.employee_management_system.repository.EmployeeRepository;
import com.ananta.employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   EmployeeRepository employeeRepository;

   public EmployeeServiceImpl(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}

    public Employee maptoEntity(EmployeeRequest request){
       Employee employee = new Employee();

       employee.setFirstName(request.getFirstName());
       employee.setLastName(request.getLastName());
       employee.setEmail(request.getEmail());
       employee.setDepartment(request.getDepartment());
       employee.setSalary(request.getSalary());
       return employee;
    }

    public EmployeeResponse maptoResponse(Employee employee){
       EmployeeResponse response = new EmployeeResponse();
       response.setId(employee.getId());
       response.setFirstName(employee.getFirstName());
       response.setLastName(employee.getLastName());
       response.setDepartment(employee.getDepartment());
       response.setEmail(employee.getEmail());
       response.setSalary(employee.getSalary());

       return response;
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) {

       Employee entity = maptoEntity(request);
       Employee savedEmployee = employeeRepository.save(entity);
       return maptoResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
       List<Employee> employeeList = employeeRepository.findAll();
       List<EmployeeResponse> responseList = new ArrayList<>();

       for(Employee employee : employeeList){
           EmployeeResponse response = new EmployeeResponse();
           response.setId(employee.getId());
           response.setFirstName(employee.getFirstName());
           response.setLastName(employee.getLastName());
           response.setEmail(employee.getEmail());
           response.setDepartment(employee.getDepartment());
           response.setSalary(employee.getSalary());

           responseList.add(response);
       }


        return responseList;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id){

        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found: "+id));
       return maptoResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
       Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found for id: "+id));
       existingEmployee.setFirstName(request.getFirstName());
       existingEmployee.setLastName(request.getLastName());
       existingEmployee.setEmail(request.getEmail());
       existingEmployee.setDepartment(request.getDepartment());
       existingEmployee.setSalary(request.getSalary());

       Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return maptoResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found for id: "+id));
        employeeRepository.delete(employee);
    }


}

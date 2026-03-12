package com.employee.system.service;

import com.employee.system.dto.EmployeeRequest;
import com.employee.system.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    Employee createEmployee(EmployeeRequest request);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
}

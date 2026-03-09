package com.product.system.service;


import com.product.system.dto.EmployeeRequest;
import com.product.system.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeRequest request);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, EmployeeRequest request);

    void deleteEmployee(Long id);
}

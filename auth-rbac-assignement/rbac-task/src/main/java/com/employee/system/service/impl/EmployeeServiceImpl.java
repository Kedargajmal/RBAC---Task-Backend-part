package com.employee.system.service.impl;

import com.employee.system.dto.EmployeeRequest;
import com.employee.system.entity.Employee;
import com.employee.system.mapper.EmployeeMapper;
import com.employee.system.repository.EmployeeRepository;
import com.employee.system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee createEmployee(EmployeeRequest request) {

        Employee employee = employeeMapper.toEntity(request);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeRepository.delete(employee);
    }
}
package com.employee.system.mapper;

import com.employee.system.dto.EmployeeRequest;
import com.employee.system.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper
{
    Employee toEntity(EmployeeRequest request);
}
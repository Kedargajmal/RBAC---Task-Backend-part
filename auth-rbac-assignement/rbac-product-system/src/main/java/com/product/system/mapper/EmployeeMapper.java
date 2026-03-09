package com.product.system.mapper;

import com.product.system.dto.EmployeeRequest;
import com.product.system.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper
{
    Employee toEntity(EmployeeRequest request);
}
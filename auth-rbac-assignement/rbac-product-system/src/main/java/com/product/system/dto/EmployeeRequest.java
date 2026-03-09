package com.product.system.dto;

import lombok.Data;

@Data
public class EmployeeRequest
{
    private String name;
    private String department;
    private Double salary;
}